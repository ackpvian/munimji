package in.co.sdslabs.iitr.munimji;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {

	public static final String ROWID = "_id";
	public static final String NAME = "_name";
	public static final String AMOUNT = "_amt";
	public static final String COMMENT = "_comments";

	private static final String AMT_DB = "AMOUNTDB";
	private static final String TABLE = "AMOUNTDB";
	private static final int DBVERSION = 1;

	private Dbmaker1 maker;
	private final Context context;
	private SQLiteDatabase database;

	private static class Dbmaker1 extends SQLiteOpenHelper {

		public Dbmaker1(Context context) {
			super(context, AMT_DB, null, DBVERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE + "(" + ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME
					+ " TEXT NOT NULL, " + AMOUNT + " DOUBLE);");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTES" + TABLE);
			onCreate(db);
		}

	}

	public Database(Context r) {
		context = r;

	}

	public Database open() {
		maker = new Dbmaker1(context);

		database = maker.getWritableDatabase();
		return this;
	}

	public void close() {
		maker.close();
	}

	public long createEntry(String name, Double amount)
			throws CursorIndexOutOfBoundsException {
		// TODO Auto-generated method stub

		Cursor c = database.query(TABLE, new String[] { NAME }, NAME + " = ?",
				new String[] { name }, null, null, null);
		if (c != null && c.getCount() > 0) {
			throw new CursorIndexOutOfBoundsException(
					"A Buddy with this name Already exists..!");
		}
		c.close();
		ContentValues cv = new ContentValues();
		cv.put(NAME, name);
		cv.put(AMOUNT, amount);
		return database.insert(TABLE, null, cv);

	}

	public void updateEntryAdd(String name, Double amount)
			throws CursorIndexOutOfBoundsException {
		// TODO Auto-generated method stub

		Cursor c = database.rawQuery("SELECT _amt FROM " + TABLE + " WHERE "
				+ NAME + " = \'" + name + "\'", null);

		if (c.moveToFirst())
			amount += c.getDouble(0);
		c.close();

		ContentValues cv = new ContentValues();
		cv.put(AMOUNT, amount);
		database.update(TABLE, cv, NAME + " = \'" + name + "\'", null);

	}

	public void updateEntrySub(String name, Double amount) {
		// TODO Auto-generated method stub

		Cursor c = database.rawQuery("SELECT _amt FROM " + TABLE + " WHERE "
				+ NAME + " = \'" + name + "\'", null);

		if (c.moveToFirst())
			amount -= c.getDouble(0);
		c.close();

		ContentValues cv = new ContentValues();
		cv.put(AMOUNT, amount);
		database.update(TABLE, cv, NAME + "=?", null);
	}

	public int getAmt() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { ROWID, NAME, AMOUNT };
		Cursor c = database.query(TABLE, columns, null, null, null, null, null);
		
		int total = 0;
		int iAmt = c.getColumnIndex(AMOUNT);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			total = total + iAmt;
		}

		return total;

	}

	public ArrayList<String> getData() {

		    String[]columns=new String[]{ ROWID,NAME, AMOUNT};
		    Cursor c =database.query(TABLE, columns, null, null, null, null, null);
		    ArrayList<String> result = new ArrayList<String>();
		    int iRow=c.getColumnIndex(ROWID);
		    int iName=c.getColumnIndex(NAME);
		    int iAmount=c.getColumnIndex(AMOUNT);

		    for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
		        result.add(c.getString(iRow)+" 				"+c.getString(iName)+"											 "+c.getString(iAmount));
		    }
		    return result;
		}
/*		String[] columns = new String[] { ROWID, NAME, AMOUNT };
		Cursor c = database.query(TABLE, columns, null, null, null, null, null);
		String result = "";

		int iName = c.getColumnIndex(NAME);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iName) + "\n";

		}

		return result;*/


	public void getSuggestions(ArrayList<String> result) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { NAME };
		Cursor c = database.query(TABLE, columns, null, null, null, null, null);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result.add(c.getString(0));
		}
	}

	public String getData2() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { ROWID, NAME, AMOUNT };
		Cursor c = database.query(TABLE, columns, null, null, null, null, null);
		String result = "";

		int total = 0;
		int iAmt = c.getColumnIndex(AMOUNT);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iAmt) + "\n";
			total = total + iAmt;
		}

		return result;
	}

	public void deleteEntry(String name2) {
		// TODO Auto-generated method stub
		database.delete(TABLE, NAME + "=?", new String[] { name2 });
	}

}
