# Проверка кода GregTech Impact и модов AE2

Проверено **11.10.2026** по опубликованным dev-JAR и исходникам. Minecraft во время этой проверки не запускался.

| Участник | Версия | Что проверено |
| --- | --- | --- |
| GregTech Impact | 5.09.35.37 | Все символические обращения к AE2/NEE/FluidCraft; реализации AE2-интерфейсов в конкретных классах |
| Impact-Core | 1.1.0.36 | Обращения к AE2/NEE/FluidCraft; реализации IRecipeProcessor; старый static-вызов API жидкостей NEE |
| AE2 | rv3-beta-1082-GTNH | Все прямые обращения к GregTech после трансформера и замены двух методов GT-интеграции |
| NEE | 1.7.47 | Все прямые обращения к AE2/GT в ветке Impact; reflection обработчиков, инструментов и старых RecipeMap |
| FluidCraft | 1.5.113-gtnh | Все прямые обращения к AE2/GT; реализации AE2-интерфейсов; выбор ветки GT5 при отсутствии RecipeMap |
| WirelessCraftingTerminal | 1.12.16 | Все прямые обращения к AE2/GT и реализации AE2-интерфейсов |

## Результаты

`Ae2LinkageAuditTest` проходит **8 526 проверок** дескрипторов классов, методов и полей, наследования и интерфейсных callbacks. Проверяются также class literals и method handles лямбд. Проверка не инициализирует классы Minecraft. Трансформер применяется к фактическому байткоду; два `@Overwrite` метода AE2 GT-интеграции при аудите заменяются скомпилированными методами нашего миксина. Это модель результата миксина, не проверка самого Mixin loader.

| Найденное расхождение | Исправление |
| --- | --- |
| canAccessData отсутствует в IGregTechTileEntity Impact | Проверка isDead, наличия meta и его обратной ссылки; hash 1/2 сохранён |
| sWireCutterList имеет другой тип поля | GTHashSet → GT_HashSet вместе с дескриптором поля |
| sendSoundToPlayers принимает double-координаты в GTNH и int в Impact | Helper с сигнатурой AE2 преобразует исходные координаты блока в int |
| injectEnergyUnits принимает ForgeDirection в GTNH и byte в Impact | Прямой helper вместо upstream fallback через исключение и reflection |

Все остальные проверенные прямые обращения после уже реализованных адаптаций разрешаются. Обратные обращения GregTech, включая Digital/Quantum Chest, AE2DigitalChestHandler, ME Output Bus, собственный старый EU P2P, покраску и регистрацию рецептов, проходят проверку символов. Конкретные реализации интерфейсов не имеют отсутствующих обязательных AE2 callbacks: default-мосты современного API сохраняют старые методы.

Reflection проверен отдельно: константы NEE совпадают с точками миксинов; замены существуют в Impact; sMappings, mNEIAllowed и mNEIName доступны с ожидаемыми модификаторами/типами; поле AEBasePart.side, которое читает старый P2P GregTech, сохраняет имя и ForgeDirection. RecipeMap отсутствует, поэтому NEE и FluidCraft выбирают старый GT5. GT_NEI_AssLineHandler существует. Регрессионный тест EU-helper проверяет все ForgeDirection, напряжение, ампераж и возвращаемое количество.

## Границы проверки

- Категория RecipeCategory и две её лямбды NEE относятся к ветке isNH=true; исходники подтверждают, что Impact выбирает isNH=false. Эта ветка исключена из проверки символов Impact. GTPP-процессор требует отдельного установленного GT++ и не включается одним наличием GregTech.
- Development-only appeng/gametests исключены. Косметические аннотации GT не считаются исполняемыми вызовами.
- ThaumicEnergistics, старые AE2 Stuff/ExtraCells2 и отсутствующие optional-моды не входят в этот бинарный прогон; для них сохраняется [отдельная проверка исходников](ae2-ecosystem.md).
- Проверка дескрипторов и callbacks не доказывает правильность игровых расчётов, сохранений, порядка событий и взаимодействий в мире. Восемь тестов и сборка проходят; игровые прогоны выполняет владелец сборки.

Исходники интеграций: [GregTech Impact](https://github.com/GT-IMPACT/GT5.09OFFBEAT), [AE2 GT](https://github.com/GTNewHorizons/Applied-Energistics-2-Unofficial/blob/rv3-beta-1082-GTNH/src/main/java/appeng/integration/modules/GT.java), [AE2 EU P2P](https://github.com/GTNewHorizons/Applied-Energistics-2-Unofficial/blob/rv3-beta-1082-GTNH/src/main/java/appeng/parts/p2p/PartP2PGT5Power.java), [NEE GT processor](https://github.com/GTNewHorizons/NotEnoughEnergistics/blob/1.7.47/src/main/java/com/github/vfyjxf/nee/processor/GregTech5RecipeProcessor.java), [FC определение GT](https://github.com/GTNewHorizons/AE2FluidCraft-Rework/blob/1.5.113-gtnh/src/main/java/com/glodblock/github/util/ModAndClassUtil.java).
