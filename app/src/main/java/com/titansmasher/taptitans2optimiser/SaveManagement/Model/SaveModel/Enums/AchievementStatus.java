package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Enums;

/**
 * Created by Danny on 15/11/2016.
 */

public enum AchievementStatus {
    Unavailable,
    InProgress,
    ToBeCollected,
    Completed,
    Unknown;

    public static AchievementStatus getFromString(String status) {
        switch (status) {
            case "Unavailable":
                return Unavailable;
            case "InProgress":
                return InProgress;
            case "ToBeCollected":
                return ToBeCollected;
            case "Completed":
                return Completed;
            default:
                return Unknown;
        }
    }
}
