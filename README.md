# Отношения модулей
```mermaid
graph TD;
    :app-->:feature:idle;
    :app-->:feature:manual;
    :feature:manual-->:data:places;
    :feature:idle-->:data:places;
    :feature:idle-->:common:ui;
    :feature:idle-->:common:navigation;
    :feature:manual-->:common:ui;
    :feature:manual-->:common:navigation;
    :data:places-->:domain:places;
```
