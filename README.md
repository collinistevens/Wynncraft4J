<div align="center">
<img src="https://cdn.wynncraft.com/img/logo.png">
<h1>Wynncraft4J</h1>
</div>

A Java wrapper that makes it simple and straightforward to interact with the [Wynncraft API](https://docs.wynncraft.com/docs/).

# Implemented Endpoints

## Player Module
- /player/\<str:username/uuid\>?fullResult
- /player

## Guild Module
- /guild/\<str:guildName\>?identifier=uuid
- /guild/prefix/\<str:guildPrefix\>?identifier=uuid
- /guild/uuid/\<str:uuid\>?identifier=uuid
- /guild/list/guild
- /guild/list/territory

## Leaderboard Module
- /leaderboards/\<str:lb_type\>?resultLimit=\<int:resultLimit\>