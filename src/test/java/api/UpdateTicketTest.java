package api;

import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        BaseTest.buildNewTicket(Status.CLOSED,2);
        Ticket ticket = new Ticket();
        ticket.setStatus(1);
        ticket.setQueue(1);
        ticket.setPriority(2);
        ticket.setId(idd);
        ticket.setTitle("Запрос на обновление. Тест.");
        updateTicketNegative(ticket);
    }

    private void updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)

        given().auth().basic("admin", "adminat")
                .pathParam("id", idd)
                .body(ticket)
                .when()
                .put("/api/tickets//{id}")
                .then()
                .statusCode(200);

        given().auth().basic("admin", "adminat")
                .pathParam("id", idd)
                .when()
                .get("/api/searches/{id}")
                .then()
                .statusCode(200);
    }
}
