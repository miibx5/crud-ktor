APPLICATION_CONTAINER_NAME=crud-ktor-app

down:
	@docker-compose down --v
run:
	@$(MAKE) down
	./gradlew clean build -x test
	docker-compose up -d --build
	docker logs ${APPLICATION_CONTAINER_NAME} --follow
setup-dependencies:
	@$(MAKE) down
	./gradlew clean build
	docker-compose up -d --build
	docker stop ${APPLICATION_CONTAINER_NAME}