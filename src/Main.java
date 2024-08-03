package src;

import src.custom_collections.CustomArrayList;
import src.services.FileDataReader;
import src.services.Path;

public class Main {

    public static void main(String[] args) {

        CustomArrayList<String> names = new CustomArrayList<>();
        FileDataReader.fulfillListFromFile(Path.PATH_TO_DATA_FOR_CUSTOM_COLLECTION.getPath(), names);
        names.showInstanceStateBehaviourAbilities();
    }
}
