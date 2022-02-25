package api;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import model.Status;
import model.Ticket;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import static io.restassured.RestAssured.given;

/** Абстрактный класс, содержащий общие для всех тестов методы */
public abstract class BaseTest {

    public static int idd;


    @BeforeClass
    public void prepare() throws IOException {
        // todo: загрузить в системные переменные "base.uri" из "config.properties"
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties")); //мой код
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        // todo: подготовить глобальные преднастройки для запросов
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUri);
        //requestSpecBuilder.addHeader(new Header("api_key", System.getProperty("api_key")));
        requestSpecBuilder.addHeader("api_key", "Mdv31");
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);// задаём заголовок accept
// задаём заголовок content-type
        RestAssured.requestSpecification = requestSpecBuilder // дополнительная инструкция полного логгирования для RestAssured
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }


    protected static Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными.
        Ticket ticket = new Ticket();
        ticket.setTitle("Создан тестовый запрос.");
        ticket.setPriority(priority);
        ticket.setStatus(status.getCode());
        ticket.setQueue(1);
        createTicket(ticket);
        return ticket;
    }

    protected static Ticket createTicket(Ticket ticket) {
        // todo: отправить HTTP запрос для создания тикета
        Response response = given()
                .body(ticket)
                .when()
                .post("/api/tickets/")
                .then()
                .statusCode(201)
                .extract()
                .response();

        //Захватил ИД из ответа
        idd = Integer.parseInt(response.jsonPath().getString("id"));
        return ticket;
    }
}
