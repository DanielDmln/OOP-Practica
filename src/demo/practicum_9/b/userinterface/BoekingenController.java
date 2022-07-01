package demo.practicum_9.b.userinterface;

import demo.practicum_9.b.model.Hotel;
import demo.practicum_9.b.model.KamerType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class BoekingenController {
    @FXML private Label label;
    @FXML private TextField naam;
    @FXML private TextField adres;
    @FXML private DatePicker aankomstdatum;
    @FXML private DatePicker vertrekdatum;
    @FXML private ComboBox kamertype;

    public void initialize() {
        kamertype.setPromptText("Maak een keuze...");
        kamertype.getItems().addAll("Standaard | 2 bedden | €60,- per nacht", "DeLuxe | 2 bedden | €85,- per nacht");
    }

    public void resetInvoer(ActionEvent actionEvent) {
        label.setText("Voer uw gegevens in!");
        naam.clear();
        adres.clear();
        aankomstdatum.getEditor().clear();
        vertrekdatum.getEditor().clear();

        kamertype.getSelectionModel().clearSelection();
        // Code hieronder werkt niet, het is me niet gelukt om erachter te komen hoe je de promptText wel weer terug zou kunnen krijgen
        // kamertype.setPromptText("Maak een keuze...");
    }

    public void boekVerblijf(ActionEvent actionEvent)
    {
        if (naam.getText().isEmpty() || adres.getText().isEmpty())
            label.setText("Voer alstublieft al uw gegevens in.");

        else if (aankomstdatum.getValue() == null || vertrekdatum.getValue() == null)
            label.setText("Kies alstublieft uw gewenste verblijfsdata.");

        else if (kamertype.getSelectionModel().isEmpty())
            label.setText("Kies alstublieft uw gewenste kamertype.");

        else if (aankomstdatum.getValue().isBefore(LocalDate.now()) || vertrekdatum.getValue().isBefore(LocalDate.now()))
            label.setText("Controleer uw data: u kunt niet in het verleden een reservatie maken.");

        else if (aankomstdatum.getValue().isAfter(vertrekdatum.getValue()))
            label.setText("Controleer uw data: u kunt niet eerder aankomen dan vertrekken.");


        else try {
            KamerType kt = new KamerType("Standaard", 2, 60.00);
            if (kamertype.getSelectionModel().isSelected(1))
                kt = new KamerType("DeLuxe", 2, 85.00);

            Hotel.getHotel().voegBoekingToe(aankomstdatum.getValue(), vertrekdatum.getValue(), naam.getText(), adres.getText(), kt);
            label.setText("Uw boeking is succesvol aangemaakt!");

            aankomstdatum.getEditor().clear();
            vertrekdatum.getEditor().clear();

//            Stage thisStage = (Stage) label.getScene().getWindow();
//            thisStage.close();
        }
        catch (Exception e) {
            label.setText(e.getMessage());
        }
    }
}