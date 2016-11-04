package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.Set;

public interface SearchPointsService {

    public Set<PointOfInterest> searchPoints(String text);
}
