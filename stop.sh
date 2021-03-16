echo "\033[1;31m----< parando o docker-compose >------\033[0m"
docker-compose -f ./docker/docker-compose.yml down --rmi all
echo "\033[1;31m----< limpando arquivos temporários >------\033[0m"
mvn clean 
echo "\033[1;32m----< concluído >------\033[0m"


# parando o container com o nome 'app'
# docker container stop app
# revemor o container com o nome 'app'
# docker container rm app
#removendo as images
# docker image rm -f ricardojob/app

# docker container stop  bd
# docker container rm bd
# docker image rm -f ricardojob/bd