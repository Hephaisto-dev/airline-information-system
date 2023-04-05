package gui;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.customer.CustomerImpl;
import businesslogic.api.manager.CustomerManager;
import datarecords.CustomerData;
import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.Mockito.*;

/**
 * @author hvd/hom
 */
@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GUIAppTest {

    static {
        if (Boolean.getBoolean("SERVER")) {
            System.setProperty("java.awt.headless", "true");
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");
        }
    }

    CustomerManager customerManager;

    @Start
    void start(Stage stage) {
        customerManager = mock(CustomerManager.class);
        BusinessLogicAPI businessLogic = mock(BusinessLogicAPI.class);
        when(businessLogic.getCustomerManager()).thenReturn(customerManager);
        new GUIApp(businessLogic).init(false).start(stage);
    }

    @Disabled
    @Test
    void testAddCustomer(FxRobot robot) {
        when(customerManager.add(any()))
                .thenReturn(new CustomerImpl(new CustomerData("1", "Elon", "Musk", LocalDate.of(1971, Month.JUNE, 28), "elonMusk@tesla.com")));

        ArgumentCaptor<CustomerImpl> customerCaptor = ArgumentCaptor.forClass(CustomerImpl.class);

        robot
                .clickOn("#firstName")
                .write("Elon")
                .clickOn("#lastName")
                .write("Musk")
                .clickOn("#dob")
                .write("1971-06-28")
                .clickOn("#saveButton");

        verify(customerManager).add(customerCaptor.capture());

        assertSoftly(softly -> {
            softly.assertThat(customerCaptor.getValue().getData().firstName()).isEqualTo("Elon");
            softly.assertThat(customerCaptor.getValue().getData().lastName()).isEqualTo("Musk");
            softly.assertThat(customerCaptor.getValue().getData().dob()).isEqualTo(LocalDate.of(1971, Month.JUNE, 28));
        });
    }

}