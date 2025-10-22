To-Do List App (Jetpack Compose + Room + MVVM)

Простое Android-приложение для ведения списка задач, разработанное с использованием **Jetpack Compose**, **Room**, и архитектуры **MVVM (Model–View–ViewModel)**.

---

Основные возможности

-  Добавление новых задач  
-  Редактирование существующих задач  
-  Отметка задачи как выполненной  
-  Удаление задач  
-  Автоматическое сохранение данных в локальной базе (Room)

---

Архитектура проекта
Проект построен по принципу **Clean Architecture** и разделён на три слоя:
**Слои:**
- **data** — работа с базой данных (`Room`)  
- **domain** — бизнес-логика и интерфейсы (`UseCase`, `Repository`, `Todo`)  
- **presentation** — слой представления (`ViewModel`, `Compose UI`)  
- **userscreen** — экран приложения (`TodoScreen`)  
- **ui.theme** — оформление (цвета, типографика, темы)

---
 Структура проекта
├── data/
│ ├── TodoDao.kt
│ ├── TodoDatabase.kt
│ ├── TodoDataRepository.kt
│ └── ToDoEntity.kt
│
├── domain/
│ ├── AddTodoUseCase.kt
│ ├── Todo.kt
│ └── TodoRepository.kt
│
├── presentation/
│ └── TodoViewModel.kt
│
├── ui.theme/
│ ├── Color.kt
│ ├── Theme.kt
│ └── Type.kt
│
├── userscreen/
│ └── TodoScreen.kt
│
└── MainActivity.kt
 Функционал
Создание задач: Добавление новых задач с указанием заголовка, даты завершения, приоритета и заметок.
Редактирование задач: Возможность редактировать существующие задачи.
Удаление задач: Удаление задач с подтверждением.
Drag-and-Drop: Перетаскивание задач между списками (выполненные и невыполненные).
Поиск задач: Фильтрация задач по ключевым словам.
Модальное окно: Редактирование задач через модальное окно.


---

## ⚙️ Используемые технологии

- **Kotlin**
- **Jetpack Compose**
- **Room Database**
- **Coroutines & Flow**
- **Material 3**
- **Clean Architecture / MVVM**

---

## 🧩 Ключевые компоненты

### 🗃️ `ToDoEntity.kt`
Модель данных для Room:
```kotlin
@Entity(tableName = "mytodos")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    var isDone: Boolean = false
)
<img width="378" height="838" alt="image" src="https://github.com/user-attachments/assets/c12d7d63-7a3e-4c15-a879-09a2fefc7106" />


