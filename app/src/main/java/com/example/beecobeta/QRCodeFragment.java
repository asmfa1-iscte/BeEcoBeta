package com.example.beecobeta;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import static android.Manifest.permission.CAMERA;

public class QRCodeFragment extends Fragment {

    private View i;
    private final Historico historico = new Historico();

    private CodeScanner mCodeScanner;
    private Activity activity;

    public QRCodeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        i = inflater.inflate(R.layout.fragment_q_r_code, container, false);


            if (checkPermission()) {
                // if permission is already granted display a toast message
                Toast.makeText(activity, "Permission Granted..", Toast.LENGTH_SHORT).show();
            } else {
                while (checkPermission() == false) {
                    Toast.makeText(activity, "Permission Not Granted..", Toast.LENGTH_SHORT).show();
                    requestPermission();
                }
            }
        CodeScannerView scannerView = i.findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(activity, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setMessage("Ganhou "+updatePointsValues(result.getText())+" pontos!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                                //((MainActivity) getParentFragment().getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.body_container, ((MainActivity) getParentFragment().getActivity()).getToHome()).commit();
                                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                //transaction.replace(R.id.body_container, ((MainActivity) getParentFragment().getActivity()).getToHome());
                                activity.recreate();
                            }
                        });
                        builder.show();
                        //Toast.makeText(activity, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        mCodeScanner.startPreview();

        return i;
    }


    /*@Override
    public void onPause() {
        if(mCodeScanner != null)
            mCodeScanner.releaseResources();
        super.onPause();
    }*/


    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    private boolean checkPermission() {
        // here we are checking two permission that is vibrate
        // and camera which is granted by user and not.
        // if permission is granted then we are returning
        // true otherwise false.
        int camera_permission = ContextCompat.checkSelfPermission(activity.getApplicationContext(), CAMERA);
        /*int vibrate_permission = ContextCompat.checkSelfPermission(activity.getApplicationContext(), VIBRATE);*/
        return camera_permission == PackageManager.PERMISSION_GRANTED /*&& vibrate_permission == PackageManager.PERMISSION_GRANTED*/;
    }


    private void requestPermission() {
        // this method is to request
        // the runtime permission.
        int PERMISSION_REQUEST_CODE = 200;
        ActivityCompat.requestPermissions(activity, new String[]{CAMERA/*, VIBRATE*/}, PERMISSION_REQUEST_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // this method is called when user
        // allows the permission to use camera.
        if (grantResults.length > 0) {
            boolean cameraaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            /*boolean vibrateaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;*/
            if (cameraaccepted /*&& vibrateaccepted*/) {
                Toast.makeText(activity, "Permission granted..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "Permission Denined \n You cannot use app without providing permission", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private int readPoints(String codigo) {
        if(historico.tryNewQRCode(codigo) == true) {
            return QRCodeTranslator.getPontos(codigo);
        }
        return 0;
    }

    public int updatePointsValues(String codigo) {
        int pontosGanhos = readPoints(codigo);
        PointsManager m = new PointsManager(DadosPerfil.getPontos(), pontosGanhos,
                DadosPerfil.getNivel(), DadosPerfil.getProgresso());
        DadosPerfil.setProgresso(m.getProgressoFinal());
        DadosPerfil.setPontos(m.getPontosFinais());
        DadosPerfil.setNivel(m.getNivelFinal());
        return pontosGanhos;
    }

}