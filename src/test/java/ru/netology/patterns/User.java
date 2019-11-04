package ru.netology.patterns;
import lombok.RequiredArgsConstructor;
import lombok.Data;

@Data
@RequiredArgsConstructor
public class User {
    private final String fullName;
    private final String phone;
}
