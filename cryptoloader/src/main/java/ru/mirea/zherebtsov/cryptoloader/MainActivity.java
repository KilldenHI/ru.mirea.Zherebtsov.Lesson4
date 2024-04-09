package ru.mirea.zherebtsov.cryptoloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.security.InvalidParameterException;

import javax.crypto.SecretKey;

import ru.mirea.zherebtsov.cryptoloader.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
    public	final	String	TAG	=	this.getClass().getSimpleName();
    private	final	int	LoaderID	=	1234;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void	onClickButton(View view){
        String input = binding.editText.getText().toString();
        if (!input.isEmpty()){
            SecretKey secretKey = MyLoader.generateKey();
            byte[] key = secretKey.getEncoded();
            byte[] shiper = MyLoader.encryptMsg(input, secretKey);
            Bundle	bundle	=	new	Bundle();
            bundle.putByteArray(MyLoader.ARG_WORD,	shiper);
            bundle.putByteArray("key",	key);
            LoaderManager.getInstance(this).initLoader(LoaderID,	bundle,	this);
        } else {
            Toast.makeText(this, "ДЯДЯ, введи текст, а потом уже жми на всякие кнопки!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public	void	onLoaderReset(@NonNull	Loader<String>	loader)	{
        Log.d(TAG,	"onLoaderReset");
    }
    @NonNull
    @Override
    public	Loader<String>	onCreateLoader(int	i,	@Nullable	Bundle	bundle)	{
        if	(i	==	LoaderID)	{
            Toast.makeText(this,	"onCreateLoader:"	+	i,	Toast.LENGTH_SHORT).show();
            return	new	MyLoader(this,	bundle);
        }
        throw new InvalidParameterException("Invalid	loader	id");
    }
    @Override
    public	void	onLoadFinished(@NonNull	Loader<String>	loader,	String	s)	{
        if	(loader.getId()	==	LoaderID)	{
            Log.d(TAG,	"onLoadFinished: "	+ s);
            Toast.makeText(this,	"onLoadFinished: "	+ s, Toast.LENGTH_SHORT).show();
        }
    }
}