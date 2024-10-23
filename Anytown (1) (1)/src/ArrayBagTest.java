import java.io.File;
import java.util.Scanner;

public class ArrayBagTest {

        public static void main(String[] args) throws Exception {

            ArrayBag buildings = new ArrayBag(14);
            File fileIn = new File("C:/Users/B00934250/Downloads/OneDrive_2024-10-15/Anytown (1)/src/buildings.txt");
            Scanner fileInput = new Scanner(fileIn);
            String buildingData;
            int marker1 = 2, marker2, marker3, marker4, marker5;
            String address, owner;
            int numberOfBedrooms, numberOfEmployees, avgTurnover;
            boolean hasGarage;

            while (fileInput.hasNextLine()) {
                buildingData = fileInput.nextLine();
                marker2 = buildingData.indexOf("|", marker1);
                marker3 = buildingData.indexOf("|", marker2 + 1);
                marker4 = buildingData.indexOf("|", marker3 + 1);
                marker5 = buildingData.indexOf("|", marker4 + 1);

                address = buildingData.substring(marker1, marker2);
                owner = buildingData.substring(marker2 + 1, marker3);

                switch (buildingData.substring(0, 1)) {
                    case "B":
                        // create new building
                        System.out.println("Building");
                        if (buildings.addNewEntry(new Building(address, owner)))
                            System.out.println("Building added");
                        else
                            System.out.println("Building not added");
                        break;
                    case "H":
                        //create new house
                        System.out.println("House");
                        numberOfBedrooms = Integer.parseInt(buildingData.substring(marker3 + 1, marker4));
                        hasGarage = Boolean.parseBoolean(buildingData.substring(marker4 + 1, marker5));
                        if (buildings.addNewEntry(new House(address, owner, numberOfBedrooms, hasGarage)))
                            System.out.println("House added");
                        else
                            System.out.println("House not added");
                        break;
                    case "S":
                        //create new shop
                        System.out.println("Shop");
                        numberOfEmployees = Integer.parseInt(buildingData.substring(marker3 + 1, marker4));
                        avgTurnover = Integer.parseInt(buildingData.substring(marker4 + 1, marker5));
                        if (buildings.addNewEntry(new Shop(address, owner, numberOfEmployees, avgTurnover)))
                            System.out.println("Shop added");
                        else
                            System.out.println("Shop not added");
                        break;
                }
            }

            System.out.println(buildings);

            if (buildings.addNewEntry(new Building("101 Main Street", "A.N. Other")))
                System.out.println("Building added");
            else
                System.out.println("Building not added");

            if (buildings.addNewEntry(new Building("102 Main Street", "B.O. Either")))
                System.out.println("Building added");
            else
                System.out.println("Building not added");

            if (buildings.addNewEntry(new Building("103  Main Street", "A.N.Y Body")))
                System.out.println("Building added");
            else
                System.out.println("Building not added");

            System.out.println(buildings);

            if (buildings.contains(new Building("101 Main Street", "Mr x")))
                System.out.println("Building Found");
            else
                System.out.println("Building Not Found");
            if (buildings.contains(new Building("102 Main Street", "Mr x")))
                System.out.println("Building Found");
            else
                System.out.println("Building Not Found");

            System.out.printf("101 Main Street is found %d times \n",
                    buildings.getFrequencyOf(new Building("101 Main Street", "Mr X")));
            System.out.printf("102 Main Street is found %d times \n",
                    buildings.getFrequencyOf(new Building("102 Main Street", "Mr X")));

        }
}

