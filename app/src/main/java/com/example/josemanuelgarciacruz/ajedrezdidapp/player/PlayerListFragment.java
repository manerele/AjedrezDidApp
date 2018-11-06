package com.example.josemanuelgarciacruz.ajedrezdidapp.player;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.josemanuelgarciacruz.ajedrezdidapp.DrawerActivity;
import com.example.josemanuelgarciacruz.ajedrezdidapp.MainActivity;
import com.example.josemanuelgarciacruz.ajedrezdidapp.R;

import com.example.josemanuelgarciacruz.ajedrezdidapp.constantes.G;
import com.example.josemanuelgarciacruz.ajedrezdidapp.proveedor.Contrato;

public class PlayerListFragment extends ListFragment
		implements LoaderManager.LoaderCallbacks<Cursor> {

	private static String etiNacionalidad = "NACIONALIDAD:  ";
	private static String etiNacimiento = "AÑO DE NACIMIENTO:  ";
	private static String etiDefuncion = "AÑO DE DEFUNCION:  ";
	private static String etiElo = "ELO:  ";


	PlayerCursorAdapter mAdapter;
	LoaderManager.LoaderCallbacks<Cursor> mCallbacks;

	ActionMode mActionMode;

	public static PlayerListFragment newInstance() {
		PlayerListFragment f = new PlayerListFragment();

		return f;
	}

	/**
	 * When creating, retrieve this instance's number from its arguments.
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		MenuItem menuItem = menu.add(Menu.NONE, G.INSERTAR, Menu.NONE, "Insertar");
		menuItem.setIcon(R.drawable.ic_action_insertar);
		menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()){
			case G.INSERTAR:
				Intent intent = new Intent(getActivity(), PlayerDetalleActivity.class);
				startActivity(intent);
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * The Fragment's UI is just a simple text view showing its
	 * instance number.
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_player_list, container, false);

		mAdapter = new PlayerCursorAdapter(getActivity());
		setListAdapter(mAdapter);

		return v;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mCallbacks = this;

		getLoaderManager().initLoader(0, null, mCallbacks);

		getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				if (mActionMode != null){
					return false;
				}
				mActionMode = getActivity().startActionMode(mActionModeCalback);
				view.setSelected(true);
				return true;
			}
		});

	}

	ActionMode.Callback mActionModeCalback = new ActionMode.Callback() {
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.menu_opciones, menu);
			return true;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch (item.getItemId()){
				case R.id.menu_editar:
					Intent intent = new Intent(getActivity(), DrawerActivity.class);
					startActivity(intent);
					break;
				case R.id.menu_borrar:
					Intent intent2 = new Intent(getActivity(), MainActivity.class);
					startActivity(intent2);
					break;
			}

			return false;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			mActionMode = null;
		}
	};

	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// This is called when a new Loader needs to be created.  This
		// sample only has one Loader, so we don't care about the ID.
		// First, pick the base URI to use depending on whether we are
		// currently filtering.
		String columns[] = new String[] { Contrato.Player._ID,
										  Contrato.Player.NOMBRE,
				                          Contrato.Player.NACIONALIDAD,
										  Contrato.Player.YEAR_NAC,
										  Contrato.Player.YEAR_DEF,
										  Contrato.Player.ELO
										};

		Uri baseUri = Contrato.Player.CONTENT_URI;

		// Now create and return a CursorLoader that will take care of
		// creating a Cursor for the data being displayed.

		String selection = null;

		return new CursorLoader(getActivity(), baseUri,
				columns, selection, null, null);
	}

	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// Swap the new cursor in.  (The framework will take care of closing the
		// old cursor once we return.)

		Uri laUriBase = Uri.parse("content://"+Contrato.AUTHORITY+"/Player");
		data.setNotificationUri(getActivity().getContentResolver(), laUriBase);
		
		mAdapter.swapCursor(data);
	}

	public void onLoaderReset(Loader<Cursor> loader) {
		// This is called when the last Cursor provided to onLoadFinished()
		// above is about to be closed.  We need to make sure we are no
		// longer using it.
		mAdapter.swapCursor(null);
	}

	public class PlayerCursorAdapter extends CursorAdapter {
		public PlayerCursorAdapter(Context context) {
			super(context, null, false);
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			int ID = cursor.getInt(cursor.getColumnIndex(Contrato.Player._ID));
			String nombre = cursor.getString(cursor.getColumnIndex(Contrato.Player.NOMBRE));
			String nacionalidad = cursor.getString(cursor.getColumnIndex(Contrato.Player.NACIONALIDAD));
			int yearNacimiento = cursor.getInt(cursor.getColumnIndex(Contrato.Player.YEAR_NAC));
			int yearDefucion = cursor.getInt(cursor.getColumnIndex(Contrato.Player.YEAR_DEF));
			int yearElo = cursor.getInt(cursor.getColumnIndex(Contrato.Player.ELO));
	
			TextView textviewNombre = (TextView) view.findViewById(R.id.textview_player_list_item_nombre);
			textviewNombre.setText(nombre);

			TextView textviewNacionalidad = (TextView) view.findViewById(R.id.textview_player_list_item_nacionalidad);
			textviewNacionalidad.setText(etiNacionalidad + nacionalidad);

			TextView textViewYearNac = (TextView) view.findViewById(R.id.textview_player_list_item_y_nac);
			textViewYearNac.setText(String.valueOf(etiNacimiento + yearNacimiento));

			TextView textViewYearDef = (TextView) view.findViewById(R.id.textview_player_list_item_y_def);
			textViewYearDef.setText(String.valueOf(etiDefuncion + yearDefucion));

			TextView textViewYearElo = (TextView) view.findViewById(R.id.textview_player_list_item_elo);
			textViewYearElo.setText(String.valueOf(etiElo + yearElo));

			ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
			int color = generator.getColor(nacionalidad); //Genera un color según el nombre
			TextDrawable drawable = TextDrawable.builder()
					.buildRound(nacionalidad.substring(0,1), color);

			ImageView image = (ImageView) view.findViewById(R.id.image_view);
			image.setImageDrawable(drawable);

			view.setTag(ID);

		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View v = inflater.inflate(R.layout.player_list_item, parent, false);
			bindView(v, context, cursor);
			return v;
		}
	}
}
