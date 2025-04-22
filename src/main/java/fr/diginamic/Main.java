package fr.diginamic;

import fr.diginamic.dao.RegionDao;

import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        RegionDao dao = new RegionDao();
        dao.createRegion("JEEJ");

        System.out.println("Region bien ajouté");

        Region region = dao.readRegion(1);

        System.out.println("Region 1 : " + region);

        List<Region> regions = dao.getAllRegions();

        for (Region regionInList : regions){
            System.out.println(regionInList);
        }
    }
}