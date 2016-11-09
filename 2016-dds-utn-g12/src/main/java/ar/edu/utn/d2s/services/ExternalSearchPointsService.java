package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.externaldependencies.bankbranch.BankBranchAPIImplMock;
import ar.edu.utn.d2s.externaldependencies.bankbranch.BankBranchAPIMock;
import ar.edu.utn.d2s.externaldependencies.cgp.CenterDTOMock;
import ar.edu.utn.d2s.externaldependencies.cgp.CgpAPIImplMock;
import ar.edu.utn.d2s.externaldependencies.cgp.CgpAPIMock;
import ar.edu.utn.d2s.externaldependencies.mappers.CenterDTOToCgpMapper;
import ar.edu.utn.d2s.model.points.PointOfInterest;
import ar.edu.utn.d2s.utils.StringUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExternalSearchPointsService implements SearchPointsService {

    private static ExternalSearchPointsService instance = null;

    public static ExternalSearchPointsService getInstance() {
        if (instance == null) {
            instance = new ExternalSearchPointsService();
        }
        return instance;
    }

    /**
     * Bank Branch external service needs two String params, so if the @param text
     * has only one word, the external service doesn't need to be called. Otherwise, split
     * @param text the text search
     * @return the points of interest matched by the external services
     */
    public Set<PointOfInterest> searchPoints(String text, Long userId) {
        BankBranchAPIMock bankBranchAPI = BankBranchAPIImplMock.getInstance();
        CgpAPIMock cgpAPI = CgpAPIImplMock.getInstance();

        Set<PointOfInterest> points = new HashSet<>();

        Set<String> words = StringUtil.getUniqueWordsFromText(text);
        if (words.size() > 1) {
            // TODO Make cartesian products and search banks in external service with all the possibilities

            //bankBranchAPi.searchBankBranches();
        }

        Set<CenterDTOMock> centers = new HashSet<>();
        CenterDTOToCgpMapper centerDTOToCgpMapper = new CenterDTOToCgpMapper();
        words.forEach(word -> centers.addAll(cgpAPI.searchCgps(word)));

        centers.forEach(centerDTOMock -> points.add(centerDTOToCgpMapper.map(centerDTOMock)));
        return points;
    }
}
