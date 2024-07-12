FROM bellsoft/liberica-openjdk-debian:21

# Установка рабочей директории
WORKDIR /app

# Копирование исходного кода в контейнер
COPY src /app/src

# Создание документации
RUN javadoc -d /app/docs -sourcepath /app/src -subpackages ru

# Установка рабочей директории для документации
WORKDIR /app/docs

# Команда по умолчанию
CMD ["javadoc", "-sourcepath", "/app/src", "-d", "/app/docs", "-subpackages", "ru"]
