package tn.esprit.tpfoyerr.service;

import tn.esprit.tpfoyerr.entity.Bloc;
import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long blocId);
    public Bloc modifyBloc(Bloc bloc);

}
