package JavaCoreCollectionSecond.BookingManagementSystem.service;

import JavaCoreCollectionSecond.BookingManagementSystem.model.User;
import JavaCoreCollectionSecond.BookingManagementSystem.model.Workspace;

public interface BookingManager {
    void bookWorkspace(User user, Workspace workspace);
    void cancelWorkspace(User user, Workspace workspace);
}