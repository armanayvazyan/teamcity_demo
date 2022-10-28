package config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VCSName {

    GIT("jetbrains.git");

    private final String value;
}
