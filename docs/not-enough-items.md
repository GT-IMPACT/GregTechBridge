# NotEnoughItems: 2.6.0-GTNH → 2.8.158-GTNH

Дата фиксации: **11.10.2026**. Целевой GregTech: **Impact 5.09.35.37**. Релиз 2.8.158-GTNH опубликован 06.10.2026 и является последним стабильным релизом на дату проверки. Координаты: `com.github.GTNewHorizons:NotEnoughItems:2.8.158-GTNH:dev`.

## Важные изменения миграции

Это обзор ключевых изменений; полный каталог всех опубликованных промежуточных версий приведён ниже. Критичность — оценка для нашей сборки, а не заявление о том, что все перечисленные ошибки у нас воспроизводились.

| Версия / этап | Изменение | Тип | Критичность | Связь с Impact 5.09.35.37 |
| --- | --- | --- | --- | --- |
| [2.6.0](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.0-GTNH) | Исходная версия сборки; параллельный profiler рецептов | Производительность | Низкая | Исходное состояние задано пользователем |
| [2.6.11](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.11-GTNH) | Расширенный поиск по образцу JEI | Функциональность | Средняя | Меняется поиск, а не API предметов GT |
| [2.6.19](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.19-GTNH) | Группы закладок и сворачиваемые предметы | Функциональность | Средняя | Меняется работа списков и сохранённых закладок |
| [2.6.35](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.35-GTNH) | Адаптация к переименованию классов GregTech | Совместимость | Высокая | В целевой версии есть fallback на старые имена Impact; дополнительная подмена строк не нужна |
| [2.6.51](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.51-GTNH) | Исправлена конкурентная регистрация GUI-областей при загрузке плагинов | Исправление | Высокая | Существенно для NEI-плагинов, в том числе обработчиков GT |
| [2.7.20](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.20-GTNH) | Кэш рендера сетки предметов | Производительность | Низкая | Влияет на большие списки GT-предметов |
| [2.7.56](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.56-GTNH), [2.7.58](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.58-GTNH) | Автокрафт и работа инструментов в нём | Функциональность | Средняя | Затрагивает container item и износ GT-инструментов |
| [2.7.62](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.62-GTNH) | Подавление звуков GT-инструментов в расчётах | Совместимость / исправление | Средняя | Upstream ожидает поле `playSound`; в Impact его нет, требуется наш мост |
| [2.7.64](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.64-GTNH) | Исправление зацикливания цепочек и оптимизация GTTools | Исправление / производительность | Высокая | Непосредственно затрагивает расчёты с инструментами |
| [2.8.11](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.11-GTNH) | Recipe Widget, прокрутка рецептов, настройка максимальной высоты | Интерфейс / API | Средняя | Нужно проверять GUI старых обработчиков GT |
| [2.8.40](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.40-GTNH) | Резервирование нечитабельного bookmarks.ini, исправления избранного и цепочек | Исправление / сохранение состояния | Высокая | Перед переходом стоит сохранить текущие закладки |
| [2.8.47](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.47-GTNH) | Возвращено публичное поле списка плагинов | Совместимость / API | Высокая | Важно для старых NEI-плагинов |
| [2.8.69](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.69-GTNH), [2.8.76](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.76-GTNH) | GTNHLib перестаёт быть обязательным; задан optional-минимум 0.9.6 | Зависимость | Средняя | Устанавливать GTNHLib только ради загрузки NEI не требуется |
| [2.8.102](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.102-GTNH) | Разрешение автокрафта контролируется сервером | Функциональность / сервер | Средняя | Проверка клиентского GUI не подтверждает серверный сценарий |
| [2.8.110](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.110-GTNH), [2.8.114](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.114-GTNH) | Изменён поиск шаблона генерации руд для overlay | Совместимость | Средняя | В Impact нет нового accessor/поля; NEI использует fallback `AXISSYMMETRICAL`, соответствие реальной сетке отдельно не проверялось |
| [2.8.111](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.111-GTNH), [2.8.113](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.113-GTNH) | Переделаны привязки клавиш и исправлены дубликаты | Интерфейс / исправление | Средняя | Проверить собственные горячие клавиши сборки |
| [2.8.125](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.125-GTNH) | Исправлены зависание автокрафта и работа GTTools | Исправление / совместимость | Высокая | Прямая связь с GT-инструментами |
| [2.8.131](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.131-GTNH), [2.8.132](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.132-GTNH) | Жидкости в рецептах и отдельный экран дерева закладок | Функциональность / API | Средняя | Проверить жидкостные рецепты GT и сохранённые цепочки |
| [2.8.148](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.148-GTNH) | Группы рецептов; изменение API представления жидкости | Совместимость / API | Высокая | Нельзя считать все сторонние плагины совместимыми только по успешному запуску |
| [2.8.153](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.153-GTNH) | Исправлен NPE у GT fluid display без NBT | Исправление / совместимость | Высокая | Важно для дисплеев жидкости Impact |
| [2.8.155](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.155-GTNH) | API пользовательского рендера жидкостей | Функциональность / API | Средняя | Дополнительные возможности; не обязательный API для старого GT |
| [2.8.156](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.156-GTNH) | Исправлен механизм поддержки старых обработчиков | Совместимость | Высокая | Важно при сохранении обработчиков Impact |
| [2.8.157](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.157-GTNH), [2.8.158](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.158-GTNH) | Исправлены падения при переносе групп и возврате в дерево удалённой группы | Исправление | Высокая | Целевая версия содержит эти исправления; каждый сценарий отдельно у нас не воспроизводился |

## Совместимость целевой версии с Impact

| Точка интеграции | Состояние upstream 2.8.158 | Наше действие | Проверка / ограничение |
| --- | --- | --- | --- |
| MetaBaseItem | Поиск нового и старого `GT_MetaBase_Item` | Подмена не нужна | Старое имя присутствует в Impact |
| GTUtility / fluid display / MetaGeneratedTool | Есть fallback на `GT_Utility`, `GT_FluidDisplayItem`, `GT_MetaGenerated_Tool` | Подмена имён не нужна | Нужные классы и `getFluidFromDisplayStack` есть в 5.09.35.37 |
| Расчёт износа инструмента | Reflection по `getToolStats` и `getToolDamagePerContainerCraft` | API не заменялся | Методы есть в Impact; полный набор инструментов не тестировался |
| Пауза звуков при расчёте | Поиск отсутствующего в Impact поля `playSound` | Java-миксин учитывает `StackInfo.isPausedItemDamageSound()` для аргумента `playSound` в `getContainerItem` | Клиент запускается, миксин применён |
| Звук поломки при наведении на закладку | Impact вызывает звук из `doDamage`, независимо от `playSound` | Redirect двух вызовов звука поломки; Kotlin-проверка флага NEI | Пользователь подтвердил исправление после повторного запуска |
| Обычный крафт / добыча | Пауза должна действовать только при выставленном флаге NEI | При снятой паузе вызов GT остаётся разрешён | Пользователь ранее сообщил об отсутствии звуков вообще и принял это; сохранение обычных звуков отдельно не подтверждено |
| Overlay генерации руд | Новый accessor, затем старое поле, затем fallback | Дополнительного миксина нет | Отображение реального шаблона генерации Impact не подтверждено |
| Обработчики рецептов GT и сторонних модов | Значительные изменения GUI/API между 2.6 и 2.8 | Дополнительных адаптеров пока нет | Запуск и пользовательская проверка не являются тестом всех машин и плагинов |

Java-миксин: `MetaGeneratedToolMixin`. Kotlin-логика: `NeiGregTechCompat`. Применение: LATE, CLIENT, только при наличии `NotEnoughItems` и `gregtech`. Изменения зафиксированы коммитом `f9ca7fa`.

## Минимальные зависимости и изменение требований

| Зависимость | В 2.6.0-GTNH | В 2.8.158-GTNH | Статус / минимальная граница | У нас |
| --- | --- | --- | --- | --- |
| Minecraft | 1.7.10 | 1.7.10 | Платформа мода | 1.7.10 |
| CodeChickenCore | Версия API для сборки 1.2.1 | Версия API для сборки 1.4.21 | Обязателен; NEI задаёт нижнюю границу через версию CCC, использованную при сборке. Для опубликованного целевого артефакта — 1.4.21 | Приходит из NEI; строгая 1.3.11 исключена из Impact и VirtualWorld |
| CodeChickenLib | Отдельная API-зависимость 1.2.1 | Отдельной зависимости в `dependencies.gradle` NEI нет | Нужные `codechicken.lib` классы содержатся в CodeChickenCore 1.4.21; старый CCL не следует добавлять по прежней схеме без проверки | GuiDraw и InventoryUtils подтверждены в JAR CCC |
| GTNHLib | Не объявлен в проверенном `dependencies.gradle` | Версия dev/compile 0.11.49; часть ColorResource встроена в NEI | Optional. В runtime metadata: `gtnhlib@[0.9.6,)`, но отсутствует в `getRequirements()` | Отдельной обязательной зависимости мост не добавляет |
| GregTech | Optional-интеграция | Optional-интеграция | Минимальная версия GT не задана; наш мост проверен только с Impact 5.09.35.37 | 5.09.35.37 |
| Forge Essentials | Не объявлен в проверенном файле | Compile-only 7.5.1 | Optional-интеграция прав; версия компиляции не является доказанным runtime-минимумом | Не проверялся |
| CubicChunks | Не объявлен в проверенном файле | Compile-only v0.1.14-alpha | Optional overlay; runtime-минимум не установлен | Не проверялся |
| commons-csv | Встроенная библиотека 1.10.0 | Встроенная библиотека 1.10.0 | Не отдельный мод для установки; для разработки разрешается Gradle | Управляется зависимостями upstream |
| ANTLR | Не объявлен в проверенном файле | Генератор 4.13.2; runtime 4.13.2 встроен | Инструмент сборки/встроенная библиотека, не обязательный пользовательский мод | Не задаёт минимум Java клиентской сборки сам по себе |
| UniMixins и Forgelin | Не требования обычной интеграции NEI | Требуются нашему мосту | См. [общие зависимости](README.md#общие-зависимости-моста) | UniMixins 0.1.19 / Forgelin 2.1.1 проверены |

В проекте `implementation` NEI оставлен с транзитивными зависимостями, чтобы получить совместимый CodeChickenCore. Минимум 0.9.6 GTNHLib относится к ситуации, когда библиотека установлена; 0.11.49 — версия разработки upstream, а не обязательный минимум NEI.

## Проверки перед распространением сборки

| Сценарий | Статус |
| --- | --- |
| Gradle build с NEI 2.8.158 и Impact 5.09.35.37 | Успешно |
| Загрузка клиентом и применение MetaGeneratedToolMixin | Подтверждено логом |
| Наведение на закладку с инструментом без звука поломки | Пользователь подтвердил исправление |
| Рецепты и перенос в верстак для всех GT-инструментов | Полный прогон не зафиксирован |
| Рецепты GT-машин, каталитические вкладки, поиск по жидкостям | Проверить отдельно |
| Перенос старых bookmarks.ini, дерево крафта, удаление/перенос групп | Проверить на копии старых закладок |
| Dedicated server, сетевые разрешения автокрафта | Не проверялись |
| Все сторонние NEI-плагины из сборки | Не проверялись |

## Источники

- [Полное сравнение 2.6.0-GTNH → 2.8.158-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/compare/2.6.0-GTNH...2.8.158-GTNH).
- [Зависимости 2.6.0](https://github.com/GTNewHorizons/NotEnoughItems/blob/2.6.0-GTNH/dependencies.gradle) и [2.8.158](https://github.com/GTNewHorizons/NotEnoughItems/blob/2.8.158-GTNH/dependencies.gradle).
- [Обязательные и optional-зависимости загрузчика](https://github.com/GTNewHorizons/NotEnoughItems/blob/2.8.158-GTNH/src/main/java/codechicken/nei/NEIModContainer.java).
- [Интеграция GT, fluid display и пауза звуков](https://github.com/GTNewHorizons/NotEnoughItems/blob/2.8.158-GTNH/src/main/java/codechicken/nei/recipe/stackinfo/GTFluidStackStringifyHandler.java).
- [Выбор шаблона генерации руд](https://github.com/GTNewHorizons/NotEnoughItems/blob/2.8.158-GTNH/src/main/java/codechicken/nei/WorldOverlayRenderer.java).

## Полная таблица опубликованных релизов

Ниже каждая опубликованная версия от исходной до целевой, включая prerelease. Краткие английские названия изменений взяты из release notes; для объёмных выпусков список сокращён, полная запись доступна по ссылке версии. Строка «список отсутствует» не означает отсутствие изменений в коде.

Тип и критичность каталога предварительно определены по описанию релиза; подробная оценка важных изменений приведена выше и имеет приоритет. Обозначение **не проверялась** относится к отдельному запуску конкретной промежуточной версии. Для строк без прямого упоминания GT нельзя выводить полную совместимость с Impact только по release notes.

| Версия | Изменения из release notes | Тип | Критичность | Проверка с Impact 5.09.35.37 |
| --- | --- | --- | --- | --- |
| [2.6.0-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.0-GTNH) | Concurrent recipe profiler | Исправление / функциональность | Средняя | Исходная версия сборки |
| [2.6.1-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.1-GTNH) | Fix #479 | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.2-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.2-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.3-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.3-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.4-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.4-GTNH-pre) (pre) | Added ability to have the NEI search be auto-focused on open. | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.5-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.5-GTNH) | Added ability to have the NEI search be auto-focused on open.; More inventory interaction enhancements - autofocus-quickclose | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.6-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.6-GTNH-pre) (pre) | More inventory interaction enhancements - autofocus-quickclose | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.7-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.7-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.8-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.8-GTNH) | Broaden visibility | Совместимость / API | Высокая | Не проверялась |
| [2.6.9-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.9-GTNH-pre) (pre) | Broaden visibility | Совместимость / API | Высокая | Не проверялась |
| [2.6.10-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.10-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.11-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.11-GTNH) | Create JEI-like Advanced Search | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.12-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.12-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.13-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.13-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.14-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.14-GTNH) | Update CCL Dep | Зависимость | Средняя | Не проверялась |
| [2.6.15-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.15-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.16-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.16-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.17-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.17-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.18-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.18-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.19-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.19-GTNH) | Add Create Groups Method to Bookmarks; Improve advanced search defaults; Collapsibleitems | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.20-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.20-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.21-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.21-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.22-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.22-GTNH) | Update ru_RU.lang | Интерфейс / локализация | Низкая | Не проверялась |
| [2.6.23-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.23-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.24-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.24-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.25-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.25-GTNH) | More QOL | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.26-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.26-GTNH) | Show "Delete Item" tooltip in Creative only | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.27-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.27-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.28-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.28-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.29-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.29-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.30-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.30-GTNH) | Allow any Character to be used as Search-Prefix | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.31-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.31-GTNH) | Small Cleanup | Сборка / обслуживание | Низкая | Не проверялась |
| [2.6.32-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.32-GTNH-pre) (pre) | Allow any Character to be used as Search-Prefix; Small Cleanup | Сборка / обслуживание | Низкая | Не проверялась |
| [2.6.33-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.33-GTNH) | NEI Optimization | Производительность | Низкая | Не проверялась |
| [2.6.34-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.34-GTNH) | Small fixes & changes | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.35-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.35-GTNH) | Rename GT Classes; Correct show Meta Keys | Совместимость / API | Высокая | Не проверялась |
| [2.6.36-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.36-GTNH) | Fix DraggedStack in Bookmarks | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.37-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.37-GTNH-pre) (pre) | Fix DraggedStack in Bookmarks | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.38-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.38-GTNH) | Try fix Item Render & GuiRecipeHandler; Update en_US.lang | Интерфейс / локализация | Низкая | Не проверялась |
| [2.6.39-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.39-GTNH) | Small Fixes | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.40-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.40-GTNH) | Disable cycle through NEI Modes if lockmode is ON | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.41-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.41-GTNH) | Give names to NEI threads | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.42-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.42-GTNH) | fix catalysts in multiblock structure recipes when shown bookmarks re… | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.44-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.44-GTNH) | Add Helioflare Power Forge (Gorge) to smelting catalysts; Small Fixes; replace GL immediate draw with Tessellator calls for chunk bounds rendering | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.45-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.45-GTNH) | Fix typo options for English GUI; Fix Zoom Position | Интерфейс / локализация | Низкая | Не проверялась |
| [2.6.46-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.46-GTNH) | Fix Presets Scroll; Fix Placeholder position in the quantity field; Hide rendering error in chat; | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.47-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.47-GTNH) | Fix handler ordering config | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.48-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.48-GTNH) | fix the handlerordering.csv being empty when created | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.49-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.49-GTNH) | Fix mob spawners spawning mobs at world 0 0 0; Fix Zoom Position in Right Panel | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.50-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.50-GTNH) | Fix restoring collapsible items state | Исправление / функциональность | Средняя | Не проверялась |
| [2.6.51-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.51-GTNH) | Fix CME in registerRectsToGuis during plugin loading; Optimize TooltipItemFilter; ItemFilter limited cache | Исправление стабильности | Высокая | Не проверялась |
| [2.6.52-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.52-GTNH) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.53-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.53-GTNH) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.6.54-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.6.54-GTNH) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.0-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.0-GTNH) | Clear Search Filter Cache after Change Settings | Производительность | Низкая | Не проверялась |
| [2.7.1-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.1-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.2-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.2-GTNH) | Fix Accept Folowing for custom recipe handlers | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.3-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.3-GTNH-pre) (pre) | Fix Accept Folowing for custom recipe handlers | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.4-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.4-GTNH) | Add Space Mode Settings to Search | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.5-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.5-GTNH-pre) (pre) | Add Space Mode Settings to Search | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.6-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.6-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.7-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.7-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.8-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.8-GTNH) | Change OptionIntegerField Width; Add RenderTooltipEvent Compat | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.9-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.9-GTNH-pre) (pre) | Change OptionIntegerField Width; Add RenderTooltipEvent Compat | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.10-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.10-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.11-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.11-GTNH) | Fixed NEI reload when changing dimension | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.12-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.12-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.13-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.13-GTNH) | Item List Sort: Ensure access to shared private field is atomic | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.14-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.14-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.15-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.15-GTNH) | Add mod handlers for mods in Per Fabrica Ad Astra modpack; Add 'Hide Item List Until Searching' option | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.16-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.16-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.17-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.17-GTNH-pre) (pre) | Fix NPE in ItemsTooltipLineHandler; fix memory leak fixes not working for MP | Исправление стабильности | Высокая | Не проверялась |
| [2.7.18-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.18-GTNH) | Fix NPE in ItemsTooltipLineHandler; fix memory leak fixes not working for MP | Исправление стабильности | Высокая | Не проверялась |
| [2.7.19-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.19-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.20-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.20-GTNH) | Created Grid Rendering Cache Mode | Производительность | Низкая | Не проверялась |
| [2.7.21-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.21-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.22-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.22-GTNH) | Subset Widget Improvement | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.23-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.23-GTNH) | Update Render Cache after window resize | Производительность | Низкая | Не проверялась |
| [2.7.24-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.24-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.25-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.25-GTNH) | Restore Issue 583 | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.26-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.26-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.27](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.27) | Change Permutation Filter | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.27-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.27-GTNH) | Change Permutation Filter | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.28-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.28-GTNH) | Added hotkey utils methods | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.29-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.29-GTNH) | Fix NC marker in recipe after fluid pattern terminal; Add loadPluginsInParallel Option | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.30-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.30-GTNH) | Use the updated ASMDataTable (with interfaces) when JarJar is present; feature: Overlays Settings GUI (Keep overlays through dimensions) | Совместимость / API | Высокая | Не проверялась |
| [2.7.31-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.31-GTNH) | Implement Forge Essentials Permission Checking | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.32-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.32-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.33-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.33-GTNH) | Add Hotkeys Widget Settings; Add option to adjust FPS rendering of items | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.34-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.34-GTNH) | prevent empty pages from being produced | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.35-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.35-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.36-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.36-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.37-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.37-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.38-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.38-GTNH) | Add AE2 Cell View handlers | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.39-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.39-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.40-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.40-GTNH) | Create Favorites Widget; More hotkeys; More Tooltips; | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.41-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.41-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.42-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.42-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.43-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.43-GTNH) | Filtering the input in the ItemQuantityField; Make the "Accepts following:" tooltip work for otherStacks | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.44-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.44-GTNH) | Subset: Memory Optimization | Производительность | Низкая | Не проверялась |
| [2.7.45-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.45-GTNH) | Add Settings: Dynamic Font Size | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.46-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.46-GTNH) | Don't exclude locals/frames when transforming. | Производительность | Низкая | Не проверялась |
| [2.7.47-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.47-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.48-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.48-GTNH) | Ignore prefix when SearchMode is ALWAYS | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.49-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.49-GTNH) | Update JarJar detection so it works when jarjar is loaded but rfb is not setup properly. | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.50-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.50-GTNH) | Fix Incorrect handleDragNDrop Implementation | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.51-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.51-GTNH) | Too Many (Hidden) Items | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.52-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.52-GTNH) | allow setOverrideName to remove name overrides | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.53-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.53-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.54-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.54-GTNH) | Add Bookmark items with recipe Option; Fix Paged Tooltip with Line Handler; Set Minimum Zoom Size; Add Translation to Item Count Details | Интерфейс / локализация | Низкая | Не проверялась |
| [2.7.55-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.55-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.56-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.56-GTNH) | Fix WorldClient leak in ItemModSpawner; Add Autocrafting Option | Исправление стабильности | Высокая | Не проверялась |
| [2.7.57-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.57-GTNH) | Fix Item Tooltip; Clear Crafting Grid after autocrafting | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.58-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.58-GTNH) | Tools in autocrafting | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.59-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.59-GTNH) | Autocrafting Improvement | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.60-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.60-GTNH) | Update Bookmark Chain Tooltip Cache | Производительность | Низкая | Не проверялась |
| [2.7.61-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.61-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.62-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.62-GTNH) | Disable play sound when crafting with gt tools | Совместимость GT | Средняя | Не проверялась |
| [2.7.63-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.63-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.64-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.64-GTNH) | Bookmarks Chains Math: fix infinity loop; Bookmarks Hotkeys: optimization thaumcraft recipes; Bookmarks Chains: Optimize GTTools; Bookmarks Chains: Use active Item as preferred if exists; … | Исправление стабильности | Высокая | Не проверялась |
| [2.7.65-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.65-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.66-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.66-GTNH) | Add ability to link Item in chat | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.67-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.67-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.68-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.68-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.69-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.69-GTNH) | Add ability to bookmark linked items | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.70-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.70-GTNH-pre) (pre) | Add ability to bookmark linked items | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.71-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.71-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.72-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.72-GTNH) | Allow handlers to hide the favorite and overlay buttons via IMC; Allowed fill crafting grid without all ingredients | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.73-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.73-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.7.74-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.74-GTNH) | Loading items after the player to ensure the hint cache works correctly in some mods; Information Handler | Производительность | Низкая | Не проверялась |
| [2.7.75-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.75-GTNH) | Custom Subsets in config; RecipeId Command | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.76-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.76-GTNH) | Strict Item Identify Format | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.77-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.77-GTNH) | Allow shift+scrolling other stacks in recipes; Crate Craftables Panel; Change panel position algorithm; Add the ability to create a chain of items with zero; … | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.78-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.78-GTNH) | Make EFR Lingering Potion Recipes Visible in NEI | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.79-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.79-GTNH) | Fix Keyboard IndexOutOfBoundsException; Fix Subset Name | Исправление стабильности | Высокая | Не проверялась |
| [2.7.80-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.80-GTNH) | Add missing lang key for favorite keybind; Recipe search improvement | Интерфейс / локализация | Низкая | Не проверялась |
| [2.7.81-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.81-GTNH) | Fix Permutation Filter; Fix(MobSpawnOverlay): avoid IOB from checking light value from block outside of world | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.82-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.82-GTNH) | Remove old entries which resulted in ghost catalysts | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.83-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.83-GTNH) | feat(moboverlay): add chat message (on/off) | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.84-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.84-GTNH) | [Extended+] Filter permutations on the left. Fail on recipe expression, when not searching a recipe. | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.85-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.85-GTNH) | Fixed Favorite Recipes in bookmarks for ingredients | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.86-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.86-GTNH) | Create Item Untranslator | Интерфейс / локализация | Низкая | Не проверялась |
| [2.7.87-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.87-GTNH) | Fix Bookmarks Shadow Items | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.88-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.88-GTNH) | Fix None hotkeys for java8 | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.89-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.89-GTNH) | Fix NBT Copy | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.90-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.90-GTNH) | Try fix Fuels | Исправление / функциональность | Средняя | Не проверялась |
| [2.7.91-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.7.91-GTNH) | Remove UXV and MAX biolab from NEI recipe catalysts; Support Inline Comments After #; Revert "Replace lambda with method reference"; Fix pressing '2' when … | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.0-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.0-GTNH) | Add more logging for fuel crash; allow the steam furnace multiblock to show up in NEI under furnaces | Исправление стабильности | Высокая | Не проверялась |
| [2.8.1-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.1-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.2-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.2-GTNH) | Force tag compounds to be initialized so doesn't happen concurrently later | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.3-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.3-GTNH-pre) (pre) | Force tag compounds to be initialized so doesn't happen concurrently later | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.4-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.4-GTNH) | Speedup rendering | Производительность | Низкая | Не проверялась |
| [2.8.5-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.5-GTNH-pre) (pre) | Add missing lang key for favorite keybind; Recipe search improvement; Fix Permutation Filter; Fix(MobSpawnOverlay): avoid IOB from checking light value from block outside of … | Исправление стабильности | Высокая | Не проверялась |
| [2.8.6-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.6-GTNH) | [Extended+] Fix the prefixed sequence parsing. | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.7-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.7-GTNH-pre) (pre) | [Extended+] Fix the prefixed sequence parsing. | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.8-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.8-GTNH) | Show Items Loading Message | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.9-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.9-GTNH) | Show Handler Icon in Bookmarks | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.10-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.10-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.11-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.11-GTNH) | Create Recipe Widget; Recipe GUI: Infinity Scroll; Recipe GUI: Max Height Settings | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.12-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.12-GTNH-pre) (pre) | Create Recipe Widget; Recipe GUI: Infinity Scroll; Recipe GUI: Max Height Settings | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.13-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.13-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.14-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.14-GTNH) | Fix tooltip item lighting; Optimize Bookmark Chains with Containers | Производительность | Низкая | Не проверялась |
| [2.8.15-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.15-GTNH) | Fix recipe tooltip lighting | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.16-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.16-GTNH) | Add a function to copy item name and meta | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.17-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.17-GTNH-pre) (pre) | Add a function to copy item name and meta | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.18-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.18-GTNH) | Fixing HUD flickering; Optimize permutations | Производительность | Низкая | Не проверялась |
| [2.8.19-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.19-GTNH) | Add recipe index to recipe handler height; Fix recipe result count | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.20-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.20-GTNH) | Add defaultbookmarkcontainers.cfg; Fix Button Texture; Fix Bookmarks Chain Tooltip Height; Add Scroll to Recipe Catalysts | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.21-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.21-GTNH) | Fix another race condition, affecting IndustrialGrafter | Исправление стабильности | Высокая | Не проверялась |
| [2.8.22-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.22-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.23-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.23-GTNH) | Clear rawText before formatting | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.24-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.24-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.25-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.25-GTNH) | Fixed shift+scroll of ingredients in the recipe GUI; Сalculate the height of the container before scrolling to the recipe | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.26-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.26-GTNH) | Show 'Delete Item' tooltip in Creative Mode; Fix hotkeys when keyBinding disabled | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.27-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.27-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.28-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.28-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.29-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.29-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.30-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.30-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.31-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.31-GTNH) | Change item slot size in GuiRecipe; Fixed small mouse movement while double-clicking causing drop all items; Fix favorite state refresh | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.32-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.32-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.33-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.33-GTNH) | Implement Dynamic Handler Height; Remove Permutations from Output; Remove try/catch from static block; Add GuiOverlapSlots for subpanels; Create normalizeRecipeQueryStack; Remove glBlitFramebuffer; Add 'Show only … | Производительность | Низкая | Не проверялась |
| [2.8.34-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.34-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.35-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.35-GTNH) | Add 'Bookmark recipe with count' Option | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.36-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.36-GTNH-pre) (pre) | Add 'Bookmark recipe with count' Option | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.37-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.37-GTNH) | Optimizing cross-dimension loading; Correctly collapse recipe; Add Tooltip for debug option; Fix Permutations for Information Handler; Extend HandlerInfo.Builder interface; Properly clears inventory before filling … | Совместимость / API | Высокая | Не проверялась |
| [2.8.38-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.38-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.39-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.39-GTNH) | Normalize Fluid Packet | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.40-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.40-GTNH) | Ignore space hotkeys when typing in search bar; Backup bookmarks.ini if loading failed; Fix missing favorites and incorrect crafting chains for recipes with identical … | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.42-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.42-GTNH) | Remove Obsolete Code from ModContainer | Совместимость / API | Высокая | Не проверялась |
| [2.8.43-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.43-GTNH) | [Memory-opti:fix leak] Fix WorldServer leak in NEIServerConfig | Исправление стабильности | Высокая | Не проверялась |
| [2.8.44-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.44-GTNH) | Add the ability to move bookmark groups between namespaces | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.45-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.45-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.46-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.46-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.47-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.47-GTNH) | Hide Untranslator Subset when Untranslator disabled; Restore NEIModContainer public plugins field; Add tooltip for "Required Crafts" with shift | Совместимость / API | Высокая | Не проверялась |
| [2.8.48-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.48-GTNH) | Added Transparency Border to recipe-background and catalyst-tab | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.49-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.49-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.50-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.50-GTNH) | Added optional subset label localization | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.51-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.51-GTNH-pre) (pre) | Added optional subset label localization | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.52-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.52-GTNH) | Fix transparency border; Correctly crop colored text | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.53-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.53-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.54-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.54-GTNH) | Fix Autocrafting for recipe without ingredients in bookmarks; Fix Recipe Handlers Padding; Fix Information Handler Background Padding | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.55-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.55-GTNH) | Format number centralisation | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.56-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.56-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.57-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.57-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.58-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.58-GTNH) | [Extended+] Quote in extended+ depending on "Quote Drop Item Name" NEI option; Add texture for toggled state of magnet button | Зависимость | Средняя | Не проверялась |
| [2.8.59-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.59-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.60-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.60-GTNH) | Added show all handlers and recipes function; Add debug text localization and tooltips | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.61-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.61-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.62-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.62-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.63-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.63-GTNH) | Added checks for abstract classes when retrieving entities | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.64-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.64-GTNH-pre) (pre) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.65-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.65-GTNH) | Align panels from center to edges | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.66-GTNH-pre](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.66-GTNH-pre) (pre) | Align panels from center to edges | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.67-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.67-GTNH) | Reset item panel page on search result size change; Fix Pull Bookmarked Items; Exclude Duplicates | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.68-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.68-GTNH) | Change Bookmarks Panel Width | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.69-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.69-GTNH) | Removed GTNHLib from required dependency | Зависимость | Средняя | Не проверялась |
| [2.8.70-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.70-GTNH) | Restore the 'get infinite items' action; Generate Single-Recipe Favorites | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.71-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.71-GTNH) | Remove Generated Favorites from Accepts Followings Tooltip | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.72-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.72-GTNH) | Always Show Recipe Ingredients Overlay | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.73-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.73-GTNH) | Optimize images | Производительность | Низкая | Не проверялась |
| [2.8.74-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.74-GTNH) | Add Favorite Item Support; fix glColor4f; disabled generateSingleRecipeFavorites by default | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.75-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.75-GTNH) | Fix bookmark slot placement logic; Fix Favorite Option | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.76-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.76-GTNH) | Set minimum GTNHLib version to 0.9.6 | Зависимость | Средняя | Не проверялась |
| [2.8.77-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.77-GTNH) | Change calculateBounds | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.78-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.78-GTNH) | Fix filtered permutations | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.79-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.79-GTNH) | updateBuildScript; Fix areStacksSameTypeWithNBT damage check | Сборка / обслуживание | Низкая | Не проверялась |
| [2.8.80-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.80-GTNH) | Add Repair Handler | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.81-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.81-GTNH) | Refactor DebugHandlerWidget | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.82-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.82-GTNH) | Add Reset to Debug Handler | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.83-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.83-GTNH) | Improve image exporter data dumper; Add recipe chance to bookmarks | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.84-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.84-GTNH) | Fix Collapsed Recipes in Bookmarks | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.85-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.85-GTNH) | Chance tooltip | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.86-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.86-GTNH) | Disable badge by default | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.87-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.87-GTNH) | Improve Recipe Badge; Fix Repair Handler with broken ItemStack | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.88-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.88-GTNH) | Refactor recipe profiler | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.89-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.89-GTNH) | Don't block slot click if canCheatItem is false | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.90-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.90-GTNH) | fix client -> server sync in creative gui | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.91-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.91-GTNH) | Fix Collapsed Recipes in Bookmarks; Rollback PR#913; Fix Autocrafting NPE | Исправление стабильности | Высокая | Не проверялась |
| [2.8.92-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.92-GTNH) | Fix bookmark recipe item order being inconsistent; Fix StringIndexOutOfBoundsException in FormattedTextField | Исправление стабильности | Высокая | Не проверялась |
| [2.8.93-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.93-GTNH) | Much faster recipe dumper | Производительность | Низкая | Не проверялась |
| [2.8.94-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.94-GTNH) | Fix Filter Loading | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.95-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.95-GTNH) | Add Horizontal Scroll to Recipe GUI; Prevent ConcurrentModificationException while searching for fuels in ItemList | Исправление стабильности | Высокая | Не проверялась |
| [2.8.96-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.96-GTNH) | GuiInfo: fix memory leaks; Options: fix memory leaks | Исправление стабильности | Высокая | Не проверялась |
| [2.8.97-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.97-GTNH) | GuiRecipe: Add scrollPages Option; Fix mui2 screen capture | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.98-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.98-GTNH) | Fix Recipe Page Area | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.99-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.99-GTNH) | Fix ItemStack load from NBT with short overflow; Smart-Fallback & Alchemic Chemistry Set Fix | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.100-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.100-GTNH) | Guard loadTransferRects against plugin init errors | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.101-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.101-GTNH) | Fix Single Item In Bookmarks With Amount | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.102-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.102-GTNH) | Add server-controlled autocraft permission | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.103-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.103-GTNH) | Fix Autocrefing Permission; Fix Broken DisplayName in Untranslator | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.104-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.104-GTNH) | Fix Config Option NPE | Исправление стабильности | Высокая | Не проверялась |
| [2.8.105-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.105-GTNH) | Convert color class; Fix Loading Items error log | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.106-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.106-GTNH) | ItemLoader Refactoring/Optimization; Persist hidden items by GUID across reloads | Производительность | Низкая | Не проверялась |
| [2.8.107-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.107-GTNH) | Allow plugins to force fill mode for overlay button | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.108-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.108-GTNH) | Add item name aliases for search | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.109-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.109-GTNH) | Fix Debug Handler | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.110-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.110-GTNH) | Update way of getting oregen pattern for GT overlay | Совместимость GT | Средняя | Не проверялась |
| [2.8.111-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.111-GTNH) | [Feature] Keybinding Refactoring | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.112-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.112-GTNH) | Remove redundant simplewasher recipe; Add offset for snow block to mob spawn overlay | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.113-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.113-GTNH) | Fix duplicate keybinding handling by patching KeyBinding static handlers; Add Cubic Chunks cube overlay & fix chunk grid above y=256, below y=0.; Fix Dynamic … | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.114-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.114-GTNH) | oregenPattern this time for sure; fix: spawner placement logic; Rework chat item link to support bookmarking recipes and groups | Совместимость GT | Средняя | Не проверялась |
| [2.8.115-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.115-GTNH) | Simplify the keybinding | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.116-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.116-GTNH) | Overlay Button moves one item if the recipe stack is size zero; Fix GL reset | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.117-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.117-GTNH) | Bookmarks Chain: fix container item multiplier limit | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.118-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.118-GTNH) | Fix Tooltip with Component in first line; Create EmptyContainer; Added Bookmark Chain Visitor | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.119-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.119-GTNH) | Add Recipe Filter syntax tooltip; Fix Untranslator With Broken Item | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.120-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.120-GTNH) | Optimize updateUnlimitedItems | Производительность | Низкая | Не проверялась |
| [2.8.121-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.121-GTNH) | Cache enum .values() | Производительность | Низкая | Не проверялась |
| [2.8.122-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.122-GTNH) | Modernize Java code | Сборка / обслуживание | Низкая | Не проверялась |
| [2.8.123-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.123-GTNH) | Bookmarks: Fix Permutations with different amount | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.124-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.124-GTNH) | Add custom render for PositionedStack | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.125-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.125-GTNH) | Fix Autocrafting Infinity Loop; Fix Autocrafting With GTTools; New worlds ignoring global cheatmode; Add Accepts Label | Исправление стабильности | Высокая | Не проверялась |
| [2.8.126-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.126-GTNH) | Fix Fluid Untranslator | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.127-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.127-GTNH) | Fix crash when recipe search results change mid-rebuild | Исправление стабильности | Высокая | Не проверялась |
| [2.8.128-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.128-GTNH) | Add feature to save history like bookmarks; Check unknown bookmark group | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.129-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.129-GTNH) | add centerOverlay | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.130-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.130-GTNH) | Various CPU and RAM improvements | Производительность | Низкая | Не проверялась |
| [2.8.131-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.131-GTNH) | Added fluid support in recipes | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.132-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.132-GTNH) | Implement Bookmark Tree Screen | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.133-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.133-GTNH) | Add Ukrainian (uk_UA) localization and translate README | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.134-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.134-GTNH) | Fix Detect Fluid Display; Destroy one pixel and add color localization | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.135-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.135-GTNH) | Fix Bookmark Fluid Factor Limit | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.136-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.136-GTNH) | Correctly filtering neifluids | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.137-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.137-GTNH) | Change Fluid Amount Limit; Fix concurrent modification crash in API.hideItem | Исправление стабильности | Высокая | Не проверялась |
| [2.8.138-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.138-GTNH) | Repair Handler Optimization; ItemFluidDisplay/getSubItems skips the last fluid | Производительность | Низкая | Не проверялась |
| [2.8.139-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.139-GTNH) | Registry NEI Fluids in Server | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.140-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.140-GTNH) | Fix Slot Highlighting | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.141-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.141-GTNH) | Item Craftables Panel Optimization | Производительность | Низкая | Не проверялась |
| [2.8.142-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.142-GTNH) | fix(NEIController): Skip MMB on slot click to avoid unecessary conflict with itemstack using it | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.143-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.143-GTNH) | Publishing | Сборка / обслуживание | Низкая | Не проверялась |
| [2.8.144-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.144-GTNH) | Отдельный список изменений отсутствует; см. сравнение в релизе | Не уточнён | Не определена | Не проверялась |
| [2.8.145-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.145-GTNH) | Add List View to Recipe | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.146-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.146-GTNH) | Refactoring Chain Tooltip | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.147-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.147-GTNH) | Fix search autofocus losing the first typed character; Fix Keybinding Category Names; Add Flowinf Texture to PositionStack | Интерфейс / локализация | Низкая | Не проверялась |
| [2.8.148-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.148-GTNH) | Add Recipe Groups to GuiRecipe; Rename PositionStack.Fluid to Tank | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.149-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.149-GTNH) | Save Tree State | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.150-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.150-GTNH) | Add widget size to recipe event | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.151-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.151-GTNH) | fix cycling for fluid permutations | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.152-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.152-GTNH) | Recipe Group Optimization | Производительность | Низкая | Не проверялась |
| [2.8.153-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.153-GTNH) | Fix EnderIo Tank; Fix NPE on GT fluid display without NBT | Исправление стабильности | Высокая | Не проверялась |
| [2.8.154-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.154-GTNH) | Fix Subset Width Calculation | Исправление / функциональность | Средняя | Не проверялась |
| [2.8.155-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.155-GTNH) | Add Custom Renderer API for Fluids | Совместимость / API | Высокая | Не проверялась |
| [2.8.156-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.156-GTNH) | Fix Old Handlers Hack | Совместимость / API | Высокая | Не проверялась |
| [2.8.157-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.157-GTNH) | Fix crash while dragging bookmark group to another grid | Исправление стабильности | Высокая | Не проверялась |
| [2.8.158-GTNH](https://github.com/GTNewHorizons/NotEnoughItems/releases/tag/2.8.158-GTNH) | Fix crash when returning to the crafting tree after its bookmark group was removed; Fix Crafting Tree NPE | Исправление стабильности | Высокая | Целевая; с мостом, частично проверена |
