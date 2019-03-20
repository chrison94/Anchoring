package validation;

import java.util.Iterator;
import org.json.JSONObject;
import functions.Hashing;

public class ValidateDatabaseEntry {

	public static void main(String[] args) {

		// Test-Values
		JSONObject dbEntry = new JSONObject().put("tableName", "accessions").put("id", "1").put("fkHeaderid", "1")
				.put("name", "A31764").put("fkAccInfoId", "0");

		JSONObject dbValidate = new JSONObject()
				.put("key", "ae0c7879b116ee05556dc0a25cd89b934e451e3daa257f325d8b25d1c9601963").put("type", "String")
				.put("value", "12314");

		JSONObject dbVal = new JSONObject();

		String hashDbEntry = jsonValidationStepOne(dbEntry);
		String hashDbEntryTimestamp = jsonValidationStepTwo(dbValidate);
		Boolean validate = jsonValidationStepThree(dbVal);

		System.out.println(hashDbEntry);
		System.out.println(hashDbEntryTimestamp);
		System.out.println(validate);

		if (validate == true) {
			System.out.println("Datenbankeintrag wurde nicht verändert"); // Ersetzen durch Feedback für User
		} else {
			System.out.println("Datenbankeintrage wurde verändert"); // Ersetzen durch Feedback für User
		}
	}

	// zu überprüfender Datenbankeintrag als JSON-Objekt - liefert gehashten
	// Datenbankeintrag als String
	public static String jsonValidationStepOne(JSONObject entry) {
		Hashing hs = new Hashing();
		String hashString = "";
		Iterator<String> jsonKeys = entry.keys();
		while (jsonKeys.hasNext()) {
			String key = jsonKeys.next();
			hashString += entry.getString(key);
		}

		String valDataInWav = hs.DatabaseValidateHash(hashString);
		return valDataInWav;
	}

	/*
	 * Man erhält JSON von der Waves API, wenn der Datenbankeintrag bereits in der
	 * Waves-API enthalten war Das zurückgelieferte (key,value)-Paar
	 * (dbEntryHash,timestamp) wird daraufhin in einen String hintereinander gepackt
	 * und erneut gehasht. Die Methode liefert diesen Hash zurück, welcher dann an
	 * die Waves-API erneut als Key-Request gesendet wird
	 */
	public static String jsonValidationStepTwo(JSONObject entry) {
		Hashing hs = new Hashing();
		String validateString = "";
		validateString += entry.get("key");
		validateString += entry.get("value");
		String dataWithTimestamp = hs.DatabaseValidateHash(validateString);
		return dataWithTimestamp;
	}

	/*
	 * Funktion um validieren zu können, ob der Datenbankeintrag als Hash in
	 * Verbindung mit dem Timestamp bereits in der Datenbank vorhanden war, Falls
	 * also das Objekt Empty ist -> False, True = Eintrag gibt es in der Chain
	 */
	public static boolean jsonValidationStepThree(JSONObject entry) {
		if (entry.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
}
