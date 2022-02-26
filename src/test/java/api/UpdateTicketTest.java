package api;

import com.google.gson.Gson;
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
        ticket.setStatus(4);
        createTicket(ticket);
        ticket.setId(idd);

        Gson gson = new Gson();
        String ticket1 = gson.toJson(ticket);

        Ticket actual = updateTicketNegative(ticket);

        String actual1 = gson.toJson(actual);
        System.out.println(ticket1);
        System.out.println(actual1);

        Assert.assertTrue(ticket.equals(actual));
    }

    private Ticket updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        ticket.setStatus(1);
        Ticket actual = given()
                .pathParam("id", idd)
                .body(ticket)
                .when()
                .put("/api/tickets//{id}")
                .then()
                .statusCode(422)
                .extract()
                .body()
                .as(Ticket.class);
        return actual;
    }
}



        /*Ticket actual = given()
                .pathParam("id", idd)
                .when()
                .get("/api/tickets//{id}")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Ticket.class);*/