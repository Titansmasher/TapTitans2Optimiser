package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Enums;

/**
 * Created by Danny on 14/11/2016.
 */

public enum AccountStatus {
    None,
    Verifying,
    Created,
    Unknown;

    public static AccountStatus getFromString(String string) {
        switch (string) {
            case "None":
                return None;
            case "Verifying":
                return Verifying;
            case "Created":
                return Created;
            default:
                return Unknown;
        }
    }
}
