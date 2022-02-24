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
        BaseTest.buildNewTicket(Status.OPEN,2);
        Ticket ticket = new Ticket();
        ticket.setStatus(1);
        ticket.setQueue(1);
        ticket.setId(idd);
        ticket.setTitle("Запрос на обновление. Тест.");
        updateTicketNegative(ticket);
    }

    private void updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)

        given().auth().basic("demo", "demo1234")
                .pathParam("id", idd)
                .body(ticket)
                .when()
                .put("/api/tickets//{id}")
                .then()
                .statusCode(200);
    }
}
