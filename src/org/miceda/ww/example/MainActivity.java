package org.miceda.ww.example;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.BasicView;
import gov.nasa.worldwind.WorldWindowGLSurfaceView;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.globes.Globe;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
	private static final float LAT = 32.1f;
	private static final float LNG = -86.2f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WorldWindowGLSurfaceView mapView = new WorldWindowGLSurfaceView(this.getApplication());
		mapView.setModel(new BasicModel());

		BasicView view = (BasicView) mapView.getView();
		Globe globe = mapView.getModel().getGlobe();
		view.setLookAtPosition(Position.fromDegrees(LAT, LNG,
				globe.getElevation(Angle.fromDegrees(LAT), Angle.fromDegrees(LNG))));

		view.setHeading(Angle.fromDegrees(0d));
		view.setTilt(Angle.fromDegrees(45d));
		view.setRange(1300000d);

		setContentView(mapView);
	}

}
