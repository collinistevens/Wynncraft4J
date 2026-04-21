package dev.ohate.wynncraft4j.response.guild;

public enum GuildRole {
    OWNER("Owner"),
    CHIEF("Chief"),
    STRATEGIST("Strategist"),
    CAPTAIN("Captain"),
    RECRUITER("Recruiter"),
    RECRUIT("Recruit");

    private final String name;

    GuildRole(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
