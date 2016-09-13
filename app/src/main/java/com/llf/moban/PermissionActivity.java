package com.llf.moban;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/13.
 */
public class PermissionActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

    }

    private void initPerssion(){
//        AndPermission.with(this)
//                .requestCode(101)
//                .permission(Manifest.permission.WRITE_CONTACTS,
//                        Manifest.permission.READ_SMS,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .send();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(PermissionActivity.this,"说明权限的重要性",Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }else{
            Toast.makeText(PermissionActivity.this,"已经有该权限了",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // 只需要调用这一句，剩下的AndPermission自动完成。
//        AndPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        switch (requestCode){
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(PermissionActivity.this,"用户同意了权限",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PermissionActivity.this,"用户拒绝了，洗洗睡吧",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

   public void submit(View v){
       initPerssion();
   }
    // 成功回调的方法，用注解即可，里面的数字是请求时的requestCode。
//    @PermissionYes(101)
//    private void getLocationYes() {
//        // 申请权限成功，可以去做点什么了。
//        Toast.makeText(this, "获取权限成功", Toast.LENGTH_SHORT).show();
//    }
//
//    // 失败回调的方法，用注解即可，里面的数字是请求时的requestCode。
//    @PermissionNo(101)
//    private void getLocationNo() {
//        // 申请权限失败，可以提醒一下用户。
//        Toast.makeText(this, "获取权限失败", Toast.LENGTH_SHORT).show();
//    }
}
