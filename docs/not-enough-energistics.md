# NotEnoughEnergistics: 1.3.25 → 1.7.47

Проверено **11.10.2026** для Impact **5.09.35.37**. [Релиз 1.7.47](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.47) опубликован 06.10.2026. Координаты: `com.github.GTNewHorizons:NotEnoughEnergistics:1.7.47:dev`. Исходная версия пользовательской сборки: **1.3.25** (`NotEnoughEnergistics-1.7.10-1.3.25`, где 1.7.10 — версия Minecraft). Проверки ниже относятся к целевой версии; перенос существующего мира отдельно не проверялся.

## Важные изменения миграции

Это обзор ключевых этапов. Полный каталог ниже включает **68 опубликованных релизов**, из них **11 предрелизов**, в диапазоне от исходной до целевой версии включительно. Совместимость промежуточных версий отдельно не проверялась.

| Версия | Изменение | Тип | Критичность | Связь с Impact |
| --- | --- | --- | --- | --- |
| [1.3.26](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.26) | Адаптация ссылок после рефакторинга FluidCraft | Совместимость / API | Высокая | NEE и FC нужно обновлять согласованно |
| [1.3.27](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.27) | Отсутствие GT_NEI_AssLineHandler больше не мешает загрузке | Совместимость | Высокая | Учитывает различия обработчиков GregTech |
| [1.4.2](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.2) | ASM заменён вызовами API | Совместимость / API | Высокая | Меняется способ интеграции с терминалами |
| [1.4.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.4) | Исправлено переполнение количества предметов при переносе NEI | Исправление | Высокая | Важно для больших машинных рецептов |
| [1.4.5](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.5) | Переход на новый RecipeMap | Совместимость / API | Высокая | В целевом коде сохранена ветка старого GT5; Impact использует её |
| [1.6.0](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.0) | В терминалы шаблонов разрешён перенос больших количеств | Функциональность | Средняя | Меняется заполнение шаблонов |
| [1.6.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.4) | Переименование классов GregTech | Совместимость / API | Высокая | Требуются подмены имён обработчика и инструментов Impact |
| [1.7.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.4) | Обновлена интеграция ME, FluidCraft и Wireless Crafting терминалов | Функциональность / API | Средняя | Проверять перенос рецептов в каждом используемом терминале |
| [1.7.6](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.6) | WirelessCraftingTerminal сделан optional | Зависимость | Средняя | Метаданные загрузчика допускают отсутствие WCT; зависимости сборки рассмотрены ниже |
| [1.7.12](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.12) | Исправлен краш Ctrl+«+» при заказе недостающих компонентов | Исправление | Высокая | Затрагивает запрос автокрафта из NEI |
| [1.7.18](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.18) | Универсальная обработка GUI | Интерфейс / API | Средняя | Изменён механизм работы с терминалами |
| [1.7.23](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.23) | Исправлен заказ недостающих ингредиентов; адаптация к native essentia / Stack Type API | Совместимость / API | Высокая | Нужен современный согласованный AE2 |
| [1.7.27](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.27) | Настройка сохранения незатрачиваемых ингредиентов NEI в ME-шаблонах | Функциональность | Средняя | Сверить с собственной фильтрацией Impact-Core |
| [1.7.33](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.33) | Исправлены большие количества в закладках и потеря вероятностных выходов при переносе GT-шаблонов | Исправление | Высокая | Прямая связь с машинными рецептами GT; Impact-Core использует собственный процессор |
| [1.7.34](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.34) | Прокрутка количества жидкостей в шаблоне | Интерфейс | Средняя | Меняется редактирование жидкостных рецептов |
| [1.7.40](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.40) | Топливо печи больше не переносится в ME-шаблоны | Исправление | Средняя | Меняется набор входов переносимого рецепта |
| [1.7.41](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.41) | Исправлен лимит переноса выходов processing-шаблонов | Исправление | Средняя | Затрагивает рецепты с несколькими выходами |
| [1.7.42](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.42) | Поддержка жидкостей NEI | Совместимость / функциональность | Средняя | Используется новый API жидкостей NEI |
| [1.7.47](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.47) | Улучшена интеграция с жидкостями | Совместимость / исправление | Высокая | Целевая версия; Impact-Core использует ItemUtils.getFluidFromDisplayStack |

## Исправления моста

| Проблема | Исправление | Критичность |
| --- | --- | --- |
| Reflection ищет `gregtech.nei.GTNEIDefaultHandler`, а в Impact есть `GT_NEI_DefaultHandler` | Late-миксин меняет строку в `<clinit>` `GregTech5RecipeProcessor`; GT-рецепты снова распознаются процессором | Высокая: рецепты GT иначе не переносятся корректно |
| Reflection ищет `gregtech.api.items.MetaGeneratedTool` | Late-миксин `ItemUtilsMixin` подставляет `GT_MetaGenerated_Tool` | Средняя: распознавание и нормализация GT-инструментов |

Интеграция Impact-Core: [регистрация](https://github.com/GT-IMPACT/Impact-Core/blob/master/src/main/java/com/impact/addon/nei/impactplugin/RecipeProcessorRegister.kt), [процессор](https://github.com/GT-IMPACT/Impact-Core/blob/master/src/main/java/com/impact/addon/nei/impactplugin/RecipeProcessorBase.kt). Метод получения жидкости перенесён из `GregTech5RecipeProcessor` в `ItemUtils`. По подтверждению владельца, импорт в Impact-Core уже заменён на `com.github.vfyjxf.nee.utils.ItemUtils.getFluidFromDisplayStack`, поэтому адаптер старой static-сигнатуры удалён. `IRecipeProcessor` и публичный список `RecipeProcessor.recipeProcessors` сохраняют совместимые сигнатуры. Для использования нового импорта нужна пересобранная версия Impact-Core.

Тест прежней static-сигнатуры и зависимость на старый тестовый бинарник Impact-Core 1.1.0.36 удалены вместе с адаптером. Актуальный пересобранный Impact-Core не включён в автоматический бинарный аудит; новый API `ItemUtils` доступен в NEE 1.7.47. Остальные сигнатуры и reflection старого GT5 рассмотрены в [аудите кода](ae2-code-audit.md).

Оба миксина применяются на клиенте и сервере при наличии `neenergistics`, `gregtech` и старого API Impact. Новые глобальные классы GregTech не создаются: NEE продолжает выбирать свою ветку старого GT5, читающую `GT_Recipe.GT_Recipe_Map.sMappings`, `mNEIAllowed` и `mNEIName`. Все эти поля присутствуют в целевом Impact. Ветка GTNH `RecipeCategory` не включается.

| Зависимость | Runtime-метаданные | Наше состояние |
| --- | --- | --- |
| AE2 | Обязателен, `rv3-beta-754-GTNH` или новее | 1082-GTNH |
| NEI | Обязателен, числовой минимум не задан | 2.8.158-GTNH |
| WirelessCraftingTerminal | Optional, при наличии `after:ae2wct@[1.12.10,)` | Транзитивная 1.12.16 |
| AE2FluidCraft | Optional, при наличии `after:ae2fc@[1.5.30-gtnh,)` | Явная 1.5.113-gtnh |
| GregTech | Optional-интеграция | Impact 5.09.35.37 |
| Baubles Expanded / CoFH Core | Зависимости опубликованного артефакта, не выведенный из этого минимум | Присутствуют в dev-среде |

Сборка и клиентская загрузка мода прошли. NEE инициализирует процессоры рецептов при игровом событии, поэтому перенос машинных рецептов, жидкости, нулевые количества незатрачиваемых ингредиентов и шаблоны с инструментами ещё требуют проверки в мире. Загрузка мода до меню не доказывает эти сценарии.

Источники: [обработчик GT5](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/src/main/java/com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor.java), [ItemUtils](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/src/main/java/com/github/vfyjxf/nee/utils/ItemUtils.java), [выбор GT5/GTNH](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/src/main/java/com/github/vfyjxf/nee/processor/RecipeProcessor.java), [runtime metadata](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/src/main/java/com/github/vfyjxf/nee/NotEnoughEnergistics.java), [зависимости](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/dependencies.gradle).


## Полный каталог изменений по версиям

Источник — [официальные GitHub Releases](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases); [совокупный diff 1.3.25 → 1.7.47](https://github.com/GTNewHorizons/NotEnoughEnergistics/compare/1.3.25...1.7.47). Ссылки в каждой строке ведут к описанию релиза и его Full Changelog. Даты публикации указаны в UTC. Суффикс `-pre` считается предрелизом, даже если GitHub Releases не выставляет флаг prerelease. Версии отсортированы численно; поздние backport-релизы могут иметь меньший номер и более позднюю дату. Пропущенные номера не являются опубликованными релизами в полученном списке.

Описания переведены на русский; подробности и PR доступны по ссылке релиза. Повторы отражают release notes, которые иногда сравнивают несколько версий сразу; наличие одинаковой записи не означает повторное применение изменения. У **14 релизов** нет отдельного списка изменений: он не восстанавливался предположениями из номера версии.

Тип и критичность — предварительная оценка по описанию релиза: высокая для изменений API, крашей, дюпов, переполнений и потери состояния; средняя для поведения и функций; низкая для косметики и обслуживания. Для кратких или отсутствующих описаний оценка может быть не определена. Optional-интеграции относятся только к сборкам, где установлен соответствующий мод. Эти оценки не доказывают воспроизведение ошибки в Impact.

| Версия | Дата UTC | Изменения из release notes | Тип | Критичность | Проверка с Impact |
| --- | --- | --- | --- | --- | --- |
| [1.3.25](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.25) | 2022-12-16 | Исходное состояние; Исправлен краш заполнения Pattern Terminal через NEI без FluidCraft | Исправление | Высокая | Исходная версия |
| [1.3.26](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.26) | 2023-01-25 | Адаптация ссылок к рефакторингу FluidCraft | Совместимость / API | Высокая | Не проверена отдельно |
| [1.3.27](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.27) | 2023-02-11 | Допускается отсутствие GT_NEI_AssLineHandler | Совместимость | Высокая | Не проверена отдельно |
| [1.3.28](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.28) | 2023-02-14 | Обновлены зависимости | Зависимость / Сборка / тесты | Средняя | Не проверена отдельно |
| [1.3.29](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.29) | 2023-02-15 | Исправлена поддержка Fluid Craft Pattern Terminal | Исправление / Функциональность | Средняя | Не проверена отдельно |
| [1.3.30](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.3.30) | 2023-02-18 | Исправления для lwjgl3ify | Исправление | Средняя | Не проверена отдельно |
| [1.4.0](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.0) | 2023-03-15 | Защита от некорректного количества в стеке | Исправление / Функциональность | Средняя | Не проверена отдельно |
| [1.4.1-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.1-pre) (pre) | 2023-05-25 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.4.2](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.2) | 2023-05-28 | ASM заменён вызовами API | Совместимость / API | Высокая | Не проверена отдельно |
| [1.4.3-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.3-pre) (pre) | 2023-12-01 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.4.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.4) | 2023-12-03 | Исправлено переполнение размера стеков в NEI overlay handlers | Исправление | Высокая | Не проверена отдельно |
| [1.4.5](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.5) | 2023-12-03 | Переход на новый RecipeMap | Совместимость / API | Высокая | Не проверена отдельно |
| [1.4.6](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.4.6) | 2023-12-04 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Не проверена отдельно |
| [1.5.0](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.5.0) | 2024-01-12 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Не проверена отдельно |
| [1.5.1](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.5.1) | 2024-01-26 | Изменено чтение recipeIndex из GuiRecipe | Интерфейс | Средняя | Не проверена отдельно |
| [1.5.2](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.5.2) | 2024-05-20 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Не проверена отдельно |
| [1.6.0](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.0) | 2024-05-04 | Разрешён перенос больших количеств в терминалы шаблонов | Функциональность | Средняя | Не проверена отдельно |
| [1.6.1-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.1-pre) (pre) | 2024-07-21 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.6.2-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.2-pre) (pre) | 2024-07-25 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.6.3](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.3) | 2024-08-23 | Исправлен краш setItemToCraft | Исправление | Высокая | Не проверена отдельно |
| [1.6.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.6.4) | 2024-09-03 | Переименование классов GregTech | Совместимость / API | Высокая | Не проверена отдельно |
| [1.7.0](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.0) | 2025-01-15 | NEE больше не обрабатывает drag-and-drop GuiLevelMaintainer | Интерфейс | Низкая | Не проверена отдельно |
| [1.7.1-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.1-pre) (pre) | 2025-05-28 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.2-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.2-pre) (pre) | 2025-05-30 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.3-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.3-pre) (pre) | 2025-06-03 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.4](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.4) | 2025-06-27 | Обновлена интеграция ME, FluidCraft и Wireless Crafting терминалов | Функциональность / API | Средняя | Не проверена отдельно |
| [1.7.5](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.5) | 2025-06-27 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Не проверена отдельно |
| [1.7.6](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.6) | 2025-07-02 | WirelessCraftingTerminal сделан optional | Зависимость | Средняя | Не проверена отдельно |
| [1.7.7](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.7) | 2025-07-20 | Исправлена кнопка NEI Overlay в BlockRenderer6343 | Исправление / Интерфейс | Средняя | Не проверена отдельно |
| [1.7.9](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.9) | 2025-07-29 | Заполнение Crafting Terminal независимо от наличия всех ингредиентов | Не определён | Не определена | Не проверена отдельно |
| [1.7.10-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.10-pre) (pre) | 2025-07-29 | Заполнение Crafting Terminal независимо от наличия всех ингредиентов | Не определён | Не определена | Предрелиз; не проверен |
| [1.7.11](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.11) | 2025-08-16 | Обновлены зависимости из-за изменений API Forestry и GT5u | Совместимость / API / Зависимость | Высокая | Не проверена отдельно |
| [1.7.12](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.12) | 2025-09-02 | Исправлен краш Ctrl+«+» при заказе недостающих компонентов | Исправление | Высокая | Не проверена отдельно |
| [1.7.13](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.13) | 2025-09-20 | Исправлены закреплённые предметы AE2 | Исправление | Средняя | Не проверена отдельно |
| [1.7.14](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.14) | 2025-09-21 | Исправлен следующий запрос | Исправление | Средняя | Не проверена отдельно |
| [1.7.15-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.15-pre) (pre) | 2025-11-04 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.16-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.16-pre) (pre) | 2025-11-14 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.17-pre](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.17-pre) (pre) | 2025-12-09 | Отдельный список изменений не опубликован; доступен Full Changelog в релизе | История / без описания | Не определена | Предрелиз; не проверен |
| [1.7.18](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.18) | 2025-12-11 | Универсальная обработка GUI | Интерфейс / API | Средняя | Не проверена отдельно |
| [1.7.19](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.19) | 2025-12-14 | Восстановлены горячие клавиши и подсказки Pattern Terminal; обновлены обязательные зависимости | Зависимость / Исправление / Интерфейс | Средняя | Не проверена отдельно |
| [1.7.20](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.20) | 2025-12-20 | Исправлены возврат GUI после заказа без предпросмотра и основной GUI | Исправление / Интерфейс | Средняя | Не проверена отдельно |
| [1.7.21](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.21) | 2025-12-25 | Исправлено открытие crafting GUI для терминала вне слота руки | Исправление / Интерфейс | Средняя | Не проверена отдельно |
| [1.7.22](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.22) | 2026-01-21 | Прокрутка Ore Dictionary больше не сбрасывает количество | Не определён | Не определена | Не проверена отдельно |
| [1.7.23](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.23) | 2026-02-11 | Исправлен заказ недостающих ингредиентов; адаптация native essentia / Stack Type API | Совместимость / API | Высокая | Не проверена отдельно |
| [1.7.24](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.24) | 2026-03-03 | Изменён PacketCraftingRequest; подробности — в PR #61 | Не определён | Не определена | Не проверена отдельно |
| [1.7.25](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.25) | 2026-03-10 | Автозаполнение аспектов в шаблонах | Функциональность | Средняя | Не проверена отдельно |
| [1.7.26](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.26) | 2026-03-10 | Поддержка Recipe Index для аспектов | Функциональность | Средняя | Не проверена отдельно |
| [1.7.27](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.27) | 2026-04-14 | Настройка сохранения незатрачиваемых ингредиентов NEI в ME-шаблонах | Функциональность | Средняя | Не проверена отдельно |
| [1.7.28](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.28) | 2026-04-15 | Исправлен краш NEI handler | Исправление | Высокая | Не проверена отдельно |
| [1.7.29](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.29) | 2026-04-26 | Оптимизированы изображения и workflow сборки | Производительность / Сборка / тесты | Низкая | Не проверена отдельно |
| [1.7.30](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.30) | 2026-06-07 | Исправлена прокрутка Ctrl до нулевого количества | Исправление | Средняя | Не проверена отдельно |
| [1.7.31](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.31) | 2026-06-12 | Изменено обновление виртуальных слотов | Не определён | Не определена | Не проверена отдельно |
| [1.7.32](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.32) | 2026-06-17 | Исправлено действие крафта WCT | Исправление | Средняя | Не проверена отдельно |
| [1.7.33](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.33) | 2026-06-19 | Исправлены большие количества при извлечении закладок, потеря вероятностных выходов GT-шаблонов и прокрутка предметов | Исправление | Высокая | Не проверена отдельно |
| [1.7.34](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.34) | 2026-07-05 | Прокрутка количества жидкостей в шаблоне | Интерфейс | Средняя | Не проверена отдельно |
| [1.7.35](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.35) | 2026-07-16 | Исправлен перебор вариантов Ore Dictionary | Исправление | Средняя | Не проверена отдельно |
| [1.7.36](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.36) | 2026-07-29 | Обновлены зависимости | Зависимость | Средняя | Не проверена отдельно |
| [1.7.37](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.37) | 2026-08-01 | Проверка количества для Dire Crafting | Не определён | Не определена | Не проверена отдельно |
| [1.7.38](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.38) | 2026-08-01 | При переносе используется выбранный игроком предмет | Исправление | Средняя | Не проверена отдельно |
| [1.7.39](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.39) | 2026-08-17 | Поддержка NEI overlay AE2 для BQ | Функциональность | Средняя | Не проверена отдельно |
| [1.7.40](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.40) | 2026-08-30 | Топливо печи больше не переносится в ME-шаблоны | Исправление | Средняя | Не проверена отдельно |
| [1.7.41](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.41) | 2026-08-31 | Исправлен лимит переноса выходов processing-шаблонов | Исправление | Средняя | Не проверена отдельно |
| [1.7.42](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.42) | 2026-09-13 | Поддержка жидкостей NEI | Совместимость / функциональность | Средняя | Не проверена отдельно |
| [1.7.43](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.43) | 2026-09-20 | Исправлена поддержка жидкостей GT6; заголовок upstream обрезан | Сборка / тесты | Низкая | Не проверена отдельно |
| [1.7.44](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.44) | 2026-09-20 | Исправлен неработающий BotaniaRecipeProcessor | Исправление | Средняя | Не проверена отдельно |
| [1.7.45](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.45) | 2026-09-22 | Поддержка поиска рецептов и применений жидкостей GT6 | Не определён | Не определена | Не проверена отдельно |
| [1.7.46](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.46) | 2026-10-04 | Arcane Inscriber использует выбранный предмет при переносе | Не определён | Не определена | Не проверена отдельно |
| [1.7.47](https://github.com/GTNewHorizons/NotEnoughEnergistics/releases/tag/1.7.47) | 2026-10-06 | Улучшена обработка жидкостей: overlay, запрос автокрафта и расчёт количества ингредиентов | Совместимость / исправление | Высокая | Целевая; загрузка с мостом проверена |
