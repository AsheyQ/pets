import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import order.Endpoints;
import order.Order;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ApiTest {
    @BeforeTest
    static void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.host + Endpoints.orderBasePath)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }
    private Order randOrder() {
        Order order = new Order();
        order.setPetId(new Random().nextInt(10000));
        order.setId(new Random().nextInt(100));
        order.setQuantity(new Random().nextInt(10));
        return order;
    }

    private void createOrder(Order order) {
        given()
                .body(order)
                .when()
                .post(Endpoints.URI + Endpoints.order)
                .then()
                .statusCode(200);
    }

    private Order getOrder(int id) {
        return given()
                .when().get(Endpoints.URI + Endpoints.order + Integer.toString(id))
                .then().assertThat().
                statusCode(200).extract().body().as(Order.class);
    }

    private Order deleteOrder(int id) {
        return given()
                .when().delete(Endpoints.URI + Endpoints.order + Integer.toString(id))
                .then().assertThat().
                statusCode(200).extract().body().as(Order.class);
    }

    @Test
    void createOrderTest() { // Создаём заказ и проверяем его получение
        Order order = randOrder();
        createOrder(order);
        Order apiOrder = getOrder(order.getId());
        assertEquals(order, apiOrder);
    }

    @Test
    void deleteOrderTest(){ // Создаём заказ, удаляем и пытемся снова получить
        Order order = randOrder();
        createOrder(order);
        Order apiOrder = getOrder(order.getId());
        deleteOrder(order.getId());
        given()
                .when().get(Endpoints.URI + Endpoints.order + Integer.toString(apiOrder.getId()))
                .then().assertThat().
                statusCode(404).extract().body().as(Order.class);
    }

    @Test
    public void inventoryTest() {

        Map inv =
                given()
                        .log().all()
                        .when()
                        .get(Endpoints.URI + "store/inventory")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().body().as(Map.class);

        Assert.assertTrue(inv.containsKey("connector_up"));
    }
}
