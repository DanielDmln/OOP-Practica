package demo.practicum_9.b.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {
	private static Hotel hetHotel;
	public static void setHotel(Hotel hotel) {
		hetHotel = hotel;
	}
	public static Hotel getHotel() {
		return hetHotel;
	}

	private String naam;
	private List<Boeking> alleBoekingen = new ArrayList<Boeking>();
	private List<KamerType> alleKamerTypen = new ArrayList<KamerType>();
	private List<Kamer> alleKamers = new ArrayList<Kamer>();
	
	public Hotel(String naam, List<Kamer> deKamers) {
		this.naam = naam;

		alleKamers = deKamers;

		for (Kamer kamer : deKamers) {
			if (!alleKamerTypen.contains(kamer.getKamerType())) {
				alleKamerTypen.add(kamer.getKamerType());
			}
		}
	}

	public String getNaam() {
		return naam;
	}

	public List<KamerType> getKamerTypen() {
		return Collections.unmodifiableList(alleKamerTypen);
	}

	public List<Boeking> getBoekingen() {
		return Collections.unmodifiableList(alleBoekingen);
	}

	public Boeking voegBoekingToe(LocalDate van, LocalDate tot, String naam, String adres, KamerType type) throws Exception {
		Kamer beschikbareKamer = zoekBeschikbareKamer(type, van, tot);

		if (beschikbareKamer == null) {
			throw new Exception("Geen kamers beschikbaar!");
		}

		Boeking boeking = new Boeking(van, tot);
		boeking.setBoeker(new Klant(naam, adres));
		boeking.setKamer(beschikbareKamer);

		alleBoekingen.add(boeking);

		return boeking;
	}
	
	private Kamer zoekBeschikbareKamer(KamerType gewensteType, LocalDate aankomst, LocalDate vertrek) {
		Kamer beschikbareKamer = null;
				
		for (Kamer kamer : alleKamers) {
			if (kamer.getKamerType().equals(gewensteType)) {
				if (isBeschikbaar(kamer, aankomst, vertrek)) {
					beschikbareKamer = kamer;
					break;
				}
			}
		}
		
		return beschikbareKamer;
	}
	
	private boolean isBeschikbaar(Kamer kamer, LocalDate aankomst, LocalDate vertrek) {
		boolean isBeschikbaar = true;

		for (Boeking boeking : alleBoekingen) {
			if (boeking.getKamer().equals(kamer)) {
				
				// bool overlap = a.start < boeking.end && boeking.start < a.end;
				// .plusDays(1) toegevoegd zodat als de vertrekdatum van een klant gelijk is aan de aankomstdatum van een andere klant
				// hier ook een andere kamernummer aan zal worden gegeven. Ik zie de aankomstdatum en vertrekdatum namelijk allebei
				// als verblijfdata, zo hebben klanten altijd de tijd om aan te komen / te vertrekken zonder de stress te hebben dat zij
				// hun kamer al vrij moeten geven.
				if (aankomst.isBefore(boeking.getVertrekDatum().plusDays(1)) && boeking.getAankomstDatum().isBefore(vertrek)) {
					isBeschikbaar = false;
					break;
				}
			}
		}
				
		return isBeschikbaar; 
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("Boekingen van hotel " + naam + ":");
		alleBoekingen.forEach(boeking -> result.append("\n\t" + boeking.getAankomstDatum() + " " + boeking.getVertrekDatum()));
		return result.toString();
	}
}