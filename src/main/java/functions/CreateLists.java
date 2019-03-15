package functions;

import java.util.ArrayList;
import java.util.List;

public class CreateLists {

	List<String> hashList = new ArrayList<String>();
	List<String> hashListTimestamp = new ArrayList<String>();
	List<Long> timestampList = new ArrayList<Long>();
	List<String> entryID = new ArrayList<String>();
	List<String> tableName = new ArrayList<String>();

	public void addHashList(String hashVal) {
		hashList.add(hashVal);
	}

	public void addHashTimestamp(String hashVal) {
		hashListTimestamp.add(hashVal);
	}

	public void addTimestamp(Long timeVal) {
		timestampList.add(timeVal);
	}

	public void addDbEntry(String entryVal) {
		entryID.add(entryVal);
	}

	public void addTableName(String tableVal) {
		tableName.add(tableVal);
	}

	public int getHashListSize() {
		return hashList.size();
	}

	public List<String> getHashList() {
		return hashList;
	}

	public List<Long> getTimestampList() {
		return timestampList;
	}

	public List<String> getHashListTimestamp() {
		return hashListTimestamp;
	}

	public List<String> getTableNameList() {
		return tableName;
	}

	public List<String> getEntryIDList() {
		return entryID;
	}

	public void clearLists() {
		hashList.clear();
		timestampList.clear();
		hashListTimestamp.clear();
		tableName.clear();
		entryID.clear();
	}

	public void removeDouble(int indexOfDouble) {
		hashList.remove(indexOfDouble);
		hashListTimestamp.remove(indexOfDouble);
		timestampList.remove(indexOfDouble);
		entryID.remove(indexOfDouble);
		tableName.remove(indexOfDouble);
	}

}
