package com.elkabani.userregistration;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    /**
     * Registers a new user and sends a confirmation notification.
     * - Uses the provided UserRepository for persistence.
     * - Uses the provided NotificationService (any implementation) to notify.
     * - Prevents duplicate registration by email address.
     *
     * @param user User to register
     * @throws DuplicateRegistrationException if a user with the same email already exists
     */
    public void registerUser(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User and user email must be provided.");
        }

        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            throw new DuplicateRegistrationException("User already registered with email: " + user.getEmail());
        }

        userRepository.save(user);

        String message = "Welcome, " + user.getName() + "! Your account has been created successfully.";
        notificationService.send(message, user.getEmail());
        System.out.println("Registered user: " + user.getName() + " <" + user.getEmail() + ">");
    }
}