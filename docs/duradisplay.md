# DuraDisplay: 1.3.2 → 1.4.6

Дата фиксации: **11.10.2026**. Целевой GregTech: **Impact 5.09.35.37**. Релиз 1.4.6 опубликован 28.08.2026 по времени Москвы и является последним стабильным релизом на дату проверки. Координаты проекта: `com.github.GTNewHorizons:DuraDisplay:1.4.6:dev`; транзитивные зависимости отключены.

## Изменения по версиям

| Версия | Изменения относительно предыдущего стабильного релиза | Тип | Критичность для миграции | Совместимость с Impact 5.09.35.37 |
| --- | --- | --- | --- | --- |
| [1.3.2](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.3.2) | Исходная версия нашей сборки; обслуживание Gradle properties и версии Tags | Сборка | Низкая | Исходное состояние задано пользователем; отдельный ретест не выполнялся |
| [1.3.3](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.3.3) | Обработчик GT-гаджетов ограничен первым metaitem, чтобы не применять его к посторонним предметам | Исправление / совместимость | Средняя | Затрагивает зажигалки и баллончики; позднее требуется подмена имени MetaGeneratedItem01 |
| [1.3.4](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.3.4) | Переход на переименованные классы GTNH и обновление зависимости GregTech | Совместимость / зависимость | Высокая | Имена GTNH расходятся с Impact: требуется мост |
| [1.3.5-pre](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.3.5-pre) | Предварительная версия после 1.3.4; отдельного списка изменений нет | Предрелиз | Не определена | Не проверялась и не выбиралась для сборки |
| [1.4.0](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.0) | Добавлен overlay заполненности рюкзаков Forestry | Функциональность / интеграция | Средняя | Не устраняет несовместимость имён GT; Forestry — отдельная optional-интеграция |
| [1.4.1-pre](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.1-pre) | Предварительная версия после 1.4.0; отдельного списка изменений нет | Предрелиз | Не определена | Не проверялась |
| [1.4.2](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.2) | Некоторые зависимости сделаны optional для предотвращения падений вне GTNH | Исправление / зависимость | Высокая | Существенно для сборки Impact, которая не обязана содержать весь GTNH |
| [1.4.3](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.3) | Снижено выделение временных объектов при отрисовке overlays | Производительность | Низкая | Имена и API Impact этим не исправляются |
| [1.4.4](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.4) | Значения enum в конфигурации читаются без учёта регистра | Конфигурация / исправление | Низкая | Прямого изменения интеграции GT нет |
| [1.4.5](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.5) | Дополнительная оптимизация обработки overlays | Производительность | Низкая | Требования моста сохраняются |
| [1.4.6](https://github.com/GTNewHorizons/DuraDisplay/releases/tag/1.4.6) | Отрисовка текста с обводкой выполняется пакетами | Производительность / рендер | Низкая | Целевая версия; основные сценарии подтверждены пользователем с мостом |

Для строк промежуточных версий совместимость оценена по release notes и целевому коду, а не отдельными запусками каждой версии.

## Что исправляет наш мост

| Проблема upstream | Реализация Impact | Исправление | Тип / критичность |
| --- | --- | --- | --- |
| `gregtech.common.items.MetaGeneratedItem01` отсутствует | `GT_MetaGenerated_Item_01` | Подмена имени при регистрации обработчика | Совместимость / высокая: иначе нет счётчиков GT-гаджетов |
| `gregtech.api.items.MetaBaseItem` отсутствует | `GT_MetaBase_Item` | Подмена имени при регистрации | Совместимость / высокая: иначе GT-инструменты не попадают в нужный обработчик прочности |
| `gregtech.api.items.ItemRadioactiveCell` отсутствует; исходный callback приводит предмет к этому типу | `GT_RadioactiveCell_Item` | Подмена имени и Kotlin-callback с API Impact | Совместимость / высокая: одной подмены строки недостаточно |
| Управление полосками через `gregtech.GTMod` | `gregtech.GT_Mod.gregtechproxy` | Подмена отключения и восстановления полосок прочности и заряда с сохранением исходных настроек | Совместимость / средняя: иначе остаётся старый рендер прочности |

Java-миксины: `OverlayDurabilityLikeMixin`, `ModSelfDrawnBarMixin`. Kotlin-логика: `DuraDisplayGregTechCompat`. Применяются поздно, на клиенте, при наличии `duradisplay` и `gregtech`.

## Минимальные и optional-зависимости

Общие требования моста перечислены в [общей таблице](README.md#общие-зависимости-моста).

| Зависимость | Статус | Минимум / ограничение | Версия upstream для сборки 1.4.6 | Наше состояние |
| --- | --- | --- | --- | --- |
| Minecraft | Обязательно | Ровно 1.7.10 в `@Mod` | 1.7.10 | 1.7.10 |
| Mixin loader | Обязательно для coremod | Числовой минимум UniMixins в `@Mod` не задан | Maven runtime: UniMixins 0.3.1 | Клиент работал на UniMixins 0.1.19; это проверенная версия, не доказанный минимум |
| GregTech | Optional для мода; нужен для нашей интеграции | `after:gregtech`, без ограничения версии | GT5-Unofficial 5.09.54.112, dev-only | Impact 5.09.35.37 с мостом |
| EnderIO | Optional | При наличии задан порядок `after:EnderIO@[2.4.18,)` | 2.10.40, compile-only | Нижняя граница взята из метаданных, не из версии компиляции |
| IC2 | Optional | Нижняя граница в DuraDisplay не задана | 2.2.828-experimental, compile-only | Явно задана 2.2.828-experimental; в клиентском логе также присутствовала транзитивная 2.2.827 — точный универсальный минимум не установлен |
| Applied Energistics 2 | Optional | Нижняя граница не задана; отсутствие AE2 обрабатывается | rv3-beta-1042-GTNH, compile-only | В проекте обновлён до rv3-beta-1082-GTNH; [мост AE2](applied-energistics-2.md), расширенные overlays отдельно не проверены |
| Forestry | Optional | Нижняя граница не задана; нужен API рюкзаков | 4.11.37, compile-only | Новая интеграция с 1.4.0; не проверялась |
| Botania | Optional | Нижняя граница не задана | 1.13.34-GTNH, compile-only | Не проверялась |
| TinkersConstruct | Optional | Нижняя граница не задана | 1.14.104-GTNH, compile-only | Не проверялась |
| TinkersMechworks | Optional | Нижняя граница не задана | 0.4.2, compile-only | Не проверялась |
| ae2stuff / NewHorizonsCoreMod | Optional compile-интеграции | Числового runtime-минимума из этих деклараций не следует | 0.10.20-GTNH / 2.9.52 | Не требуют установки всего GTNH |
| NoHotbarNeeded / Angelica | Compile-only | Не объявлены обязательными runtime-зависимостями DuraDisplay | 0.0.4 / 2.2.8 | Не добавлялись как требования моста |

Нельзя трактовать GT5-Unofficial 5.09.54.112 как минимальный GregTech: это другая реализация и версия сборки upstream. Наш мост адресует API Impact 5.09.35.37.

### Изменение версий optional-интеграций upstream

Это сравнение версий разработки из двух `dependencies.gradle`, а не требование обновить все перечисленные моды в нашей сборке.

| Интеграция | При сборке 1.3.2 | При сборке 1.4.6 | Что это означает для миграции |
| --- | --- | --- | --- |
| GT5-Unofficial | 5.09.48.56 | 5.09.54.112 | Другой API GregTech; адаптация Impact сделана мостом |
| Applied Energistics 2 | rv3-beta-405-GTNH | rv3-beta-1042-GTNH | Большой разрыв версий; расширенную интеграцию со старым AE2 нужно проверять отдельно |
| EnderIO | 2.8.6 | 2.10.40 | Версия компиляции выросла; заявленный `after`-порог остаётся 2.4.18 |
| IC2 | 2.2.828-experimental | 2.2.828-experimental | Версия компиляции не менялась |
| ae2stuff | 0.8.2-GTNH, dev runtime | 0.10.20-GTNH, compile-only | Изменились версия и область зависимости |
| NewHorizonsCoreMod | 2.5.16, dev runtime | 2.9.52, compile-only | Изменились версия и область зависимости |
| Botania | 1.11.3-GTNH | 1.13.34-GTNH | Минимум runtime не объявлен |
| TinkersConstruct | 1.12.4-GTNH | 1.14.104-GTNH | Минимум runtime не объявлен |
| TinkersMechworks | 0.3.1 | 0.4.2 | Минимум runtime не объявлен |
| Forestry / NoHotbarNeeded / Angelica | Не объявлены в проверенном файле | 4.11.37 / 0.0.4 / 2.2.8 | Новые compile-only зависимости; не обязательный набор модов для пользователя |

## Проверки и ограничения

| Проверка | Результат |
| --- | --- |
| Сборка Java-миксинов и Kotlin-кода с Impact 5.09.35.37 | Успешно |
| Применение late-миксина регистрации | Подтверждено клиентским логом |
| Отображение заряда и замена старой полоски прочности | Пользователь подтвердил работоспособность после исправления |
| Радиоактивные ячейки, все баллончики и зажигалки | Код адаптирован; отдельный полный игровой тест всех вариантов не зафиксирован |
| Forestry, Botania, Tinkers и остальные optional-интеграции | Не проверялись |

Первое исправление зафиксировано коммитом `165e020`. Совместимость не распространяется автоматически на произвольную версию GregTech.

## Источники

- [Полное сравнение 1.3.2 → 1.4.6](https://github.com/GTNewHorizons/DuraDisplay/compare/1.3.2...1.4.6).
- [Runtime metadata и порядок загрузки 1.4.6](https://github.com/GTNewHorizons/DuraDisplay/blob/1.4.6/src/main/java/com/caedis/duradisplay/DuraDisplay.java).
- [Зависимости для сборки 1.3.2](https://github.com/GTNewHorizons/DuraDisplay/blob/1.3.2/dependencies.gradle) и [1.4.6](https://github.com/GTNewHorizons/DuraDisplay/blob/1.4.6/dependencies.gradle).
- [Maven POM 1.4.6](https://nexus.gtnewhorizons.com/repository/public/com/github/GTNewHorizons/DuraDisplay/1.4.6/DuraDisplay-1.4.6.pom).
- [Исходный механизм переключения полосок](https://github.com/GTNewHorizons/DuraDisplay/blob/1.4.6/src/main/java/com/caedis/duradisplay/utils/ModSelfDrawnBar.java).
