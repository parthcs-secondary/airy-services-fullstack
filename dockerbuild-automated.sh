echo "Build script started"

docker build -t parthkarad/e-commerce-backend-api-gateway-v2 -f api-gateway/Dockerfile ./api-gateway/.
docker build -t parthkarad/e-commerce-backend-authorization-service-v2 -f authorization-service/Dockerfile ./authorization-service/. 
docker build -t parthkarad/e-commerce-backend-inventory-service-v2 -f inventory-service/Dockerfile ./inventory-service/.
docker build -t parthkarad/e-commerce-backend-order-service-v2 -f order-service/Dockerfile ./order-service/.
docker build -t parthkarad/e-commerce-backend-product-service-v2 -f product-service/Dockerfile ./product-service/.
docker build -t parthkarad/e-commerce-backend-service-registry-v2 -f service-registry/Dockerfile ./service-registry/.


if [ $? -eq 0 ]; then
        echo "Build completed. Please check images with cmd 'docker images'"

else
        echo "Failed to build image"
fi
