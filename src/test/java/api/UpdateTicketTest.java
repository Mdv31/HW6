package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        Ticket ticket = BaseTest.buildNewTicket(Status.CLOSED, 2);
        createTicket(ticket);
        ticket.setStatus(1);
        updateTicketNegative(ticket);
    }

    private void updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)

        given()
                .pathParam("id", idd)
                .body(ticket)
                .when()
                .put("/api/tickets//{id}")
                .then()
                .statusCode(200);

        Ticket actual = given()
                .pathParam("id", idd)
                .when()
                .get("/api/tickets//{id}")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Ticket.class);



        int a1 = actual.hashCode();
        int a2 = ticket.hashCode();

        Assert.assertEquals(a1, a2);
    }
}
