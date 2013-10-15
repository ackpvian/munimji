package in.co.sdslabs.iitr.munimji;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseGroup {

	public static final String ROWID = "_id";
	public static final String GROUPNAME = "_groupname";
	public static final String PAIDNAME = "_paidname";
	public static final String TAKERNAME = "_takername";
	public static final String DATE = "_date";
	public static final String FOR = "_for";
	public static final String AMOUNT = "_amt";

	private static final String GRP_DB = "GROUPDB";
	public static String TABLE = "GROUPDB";
	private static final int DBVERSION = 1;

	private Dbmaker1 maker;
	private final Context context;
	private SQLiteDatabase DatabaseGroup;

	private static class Dbmaker1 extends SQLiteOpenHelper {

		public Dbmaker1(Context context) {
			super(context, GRP_DB, null, DBVERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE + "(" + ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + GROUPNAME
					+ " TEXT NOT NULL, " + PAIDNAME + " TEXT NOT NULL,"
					+ TAKERNAME + " TEXT NOT NULL," + DATE + " TEXT NOT NULL, "
					+ FOR + " TEXT NOT NULL, " + AMOUNT + " DOUBLE);");
				}
		

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTES" + TABLE);
			onCreate(db);

		}

	}

	public DatabaseGroup(Context r) {
		context = r;

	}

	public DatabaseGroup open() {
		maker = new Dbmaker1(context);

		DatabaseGroup = maker.getWritableDatabase();
		return this;
	}

	public void close() {
		maker.close();
	}

	public long createEntry(String groupname, String paidname,
			String takername, String when, String forWhat, Double amount)
			throws CursorIndexOutOfBoundsException {
		// TODO Auto-generated method stub

		ContentValues cv = new ContentValues();
		cv.put(GROUPNAME, groupname);
		cv.put(PAIDNAME, paidname);
		cv.put(TAKERNAME, takername);
		cv.put(FOR, forWhat);
		cv.put(DATE, when);
		cv.put(AMOUNT, amount);
		return DatabaseGroup.insert(TABLE, null, cv);

	}

	/*
	 * public void updateEntryAdd(String name, String when, String forWhat,
	 * Double amount) throws CursorIndexOutOfBoundsException { // TODO
	 * Auto-generated method stub
	 * 
	 * Cursor c = DatabaseGroup.rawQuery("SELECT _amt FROM " + TABLE + " WHERE "
	 * + NAME + " = \'" + name + "\'", null);
	 * 
	 * if (c.moveToFirst()) amount += c.getDouble(0); c.close();
	 * 
	 * ContentValues cv = new ContentValues(); cv.put(AMOUNT, amount);
	 * DatabaseGroup.update(TABLE, cv, NAME + " = \'" + name + "\'", null);
	 * 
	 * }
	 * 
	 * public void updateEntrySub(String name, Double amount) { // TODO
	 * Auto-generated method stub
	 * 
	 * Cursor c = DatabaseGroup.rawQuery("SELECT _amt FROM " + TABLE + " WHERE "
	 * + NAME + " = \'" + name + "\'", null);
	 * 
	 * if (c.moveToFirst()) amount -= c.getDouble(0); c.close();
	 * 
	 * ContentValues cv = new ContentValues(); cv.put(AMOUNT, amount);
	 * DatabaseGroup.updateWithOnConflict(TABLE, cv, NAME + "=?", null,
	 * SQLiteDatabaseGroup.CONFLICT_IGNORE); }
	 */

	/*
	 * public int getAmt() { // TODO Auto-generated method stub String[] columns
	 * = new String[] { ROWID, NAME, AMOUNT }; Cursor c =
	 * DatabaseGroup.query(TABLE, columns, null, null, null, null, null);
	 * 
	 * int total = 0; int iAmt = c.getColumnIndex(AMOUNT);
	 * 
	 * for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) { total = total +
	 * iAmt; }
	 * 
	 * return total;
	 * 
	 * }
	 * 
	 * public String getData() {
	 * 
	 * // TODO Auto-generated method stub String[] columns = new String[] {
	 * ROWID, NAME, AMOUNT }; Cursor c = DatabaseGroup.query(TABLE, columns,
	 * null, null, null, null, null); String result = "";
	 * 
	 * int iName = c.getColumnIndex(NAME);
	 * 
	 * for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) { result = result
	 * + c.getString(iName) + "\n";
	 * 
	 * }
	 * 
	 * return result; }
	 * 
	 * public void getSuggestions(ArrayList<String> result) { // TODO
	 * Auto-generated method stub String[] columns = new String[] { NAME };
	 * Cursor c = DatabaseGroup.query(TABLE, columns, null, null, null, null,
	 * null);
	 * 
	 * for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	 * result.add(c.getString(0)); } }
	 * 
	 * public String getData2() { // TODO Auto-generated method stub String[]
	 * columns = new String[] { ROWID, NAME, AMOUNT }; Cursor c =
	 * DatabaseGroup.query(TABLE, columns, null, null, null, null, null); String
	 * result = "";
	 * 
	 * int total = 0; int iAmt = c.getColumnIndex(AMOUNT);
	 * 
	 * for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) { result = result
	 * + c.getString(iAmt) + "\n"; total = total + iAmt; }
	 * 
	 * return result; }
	 * 
	 * public void deleteEntry(String name2) { // TODO Auto-generated method
	 * stub DatabaseGroup.delete(TABLE, NAME + "=?", new String[] { name2 }); }
	 */

	public String getData() {

		// TODO Auto-generated method stub
		String[] columns = new String[] { ROWID, GROUPNAME, PAIDNAME,
				TAKERNAME, DATE, FOR, AMOUNT };
		Cursor c = DatabaseGroup.query(TABLE, columns, null, null, null, null,
				null);
		String result = "";

		int iPaidName = c.getColumnIndex(PAIDNAME);
		int iTakerName = c.getColumnIndex(TAKERNAME);
		int iDate = c.getColumnIndex(DATE);
		int iFor = c.getColumnIndex(FOR);
		int iAmount = c.getColumnIndex(AMOUNT);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iPaidName) + " paid "
					+ c.getString(iAmount) + " to " + c.getString(iTakerName)
					+ " on " + c.getString(iDate) + " for " + c.getString(iFor)
					+ "\n\n";

		}

		return result;
	}

}
