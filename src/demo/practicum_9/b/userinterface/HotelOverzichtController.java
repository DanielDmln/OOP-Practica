package demo.practicum_9.b.userinterface;

import demo.practicum_9.b.model.Boeking;
import demo.practicum_9.b.model.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HotelOverzichtController {
    @FXML private Label hotelnaamLabel;
    @FXML private ListView boekingenListView;
    @FXML private DatePicker overzichtDatePicker;

    private Hotel hotel = Hotel.getHotel();

    public void initialize() {
        hotelnaamLabel.setText("Boekingen hotel " + hotel.getNaam());
        overzichtDatePicker.setValue(LocalDate.now());
        toonBoekingen();
    }

    public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }

    // Maak in je project een nieuwe FXML-pagina om boekingen te kunnen invoeren
    // Open de nieuwe pagina in deze methode
    // Zorg dat de gebruiker ondertussen geen gebruik kan maken van de HotelOverzicht-pagina
    // Update na sluiten van de nieuwe pagina het boekingen-overzicht
    public void nieuweBoeking(ActionEvent actionEvent) throws Exception {
        String fxmlPagina = "Boekingen.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Boeking");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // Vraag de boekingen op bij het Hotel-object.
    // Voeg voor elke boeking in nette tekst (string) toe aan de boekingen-lijst.
    public void toonBoekingen() {
        ObservableList<String> boekingen = FXCollections.observableArrayList();

        for (int i = 0; i < hotel.getBoekingen().size(); i++) {
            Boeking boeking = hotel.getBoekingen().get(i);

            if (boeking.getAankomstDatum().isBefore(overzichtDatePicker.getValue().plusDays(1)) &&
                    boeking.getVertrekDatum().isAfter(overzichtDatePicker.getValue().minusDays(1))) {
                boekingen.add("BD: " + boeking.getAankomstDatum() + "   |   ED: " +  boeking.getVertrekDatum() + "   |   Kamer: " +
                        boeking.getKamer().getKamerNummer() + "   |   Klant: " + boeking.getBoeker().getNaam());
            }
        }
        boekingenListView.setItems(boekingen);
    }
}