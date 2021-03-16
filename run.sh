echo "\033[1;31m----< gerando .war >------\033[0m"
mvn clean package 
echo "\033[1;31m----< iniciando o docker-compose >------\033[0m"
docker-compose -f ./docker/docker-compose.yml up --build -d
echo "\033[1;31m----< limpando arquivos temporários >------\033[0m"
mvn clean 
echo "\033[1;32m----< concluído >------\033[0m"


# docker image build -t ricardojob/bd ./postgres
# docker container run -p 5433:5432 --name bd -d ricardojob/bd 

# cd app && mvn clean package && cd ..
# docker image build -t ricardojob/app ./app
# docker container run -p 8080:8080 --name app -d --link bd:host-banco ricardojob/app
# echo 'fim'
