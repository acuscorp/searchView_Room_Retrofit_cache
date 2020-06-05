package com.acuscorp.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
  private NegocioRepository repository;
  private LiveData<List<Negocio>> allNegocios;

  public ViewModel(@NonNull Application application) {
    super(application);
    repository = new NegocioRepository(application);
    allNegocios = repository.getAllNegocios();
  }
  public void insert(Negocio note){
    repository.insert(note);

  }

  public LiveData<List<Negocio>> getAllNegocios() {
    return allNegocios;
  }
}
