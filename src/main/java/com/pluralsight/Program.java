package com.pluralsight;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Asset> assetList = getAssets();


        for (Asset asset: assetList) {
            System.out.printf("""
                    Description: %s
                    Date acquired: %s
                    Paid: %.2f
                    Cost: %.2f
                    """, asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost(), asset.getValue());
            if (asset instanceof House) {
                System.out.printf("""
                        Address: %s
                        """,((House) asset). getAddress());
            } else if (asset instanceof Vehicle) {
                System.out.printf("""
                        Year: %s
                        Make/Model: %s
                        """, ((Vehicle) asset).getYear(), ((Vehicle) asset).getMakeModel());

            }

        }
    }

    private static ArrayList<Asset> getAssets() {
        ArrayList<Asset> assetList = new ArrayList<>();

        Asset house1 = new House("Jack's small house", "5/5/2020", 20000, "123 S Harmon Ave. Chicago", 3, 2000, 300);

        Asset house2 = new House("my Big house", "3/22/2025", 150000, "400 s mon New York", 2, 2000, 700);

        Asset vehicle1 = new Vehicle("my fast car", "1/02/2025", 2500, "Ford Mustang", 2023, 75000);

        Asset vehicle2 = new Vehicle("Tom's smelly car", "3/30/2025", 15000, "Nissan Sonata", 2017, 100000);

        assetList.add(house1);
        assetList.add(house2);
        assetList.add(vehicle1);
        assetList.add(vehicle2);
        return assetList;
    }
}
