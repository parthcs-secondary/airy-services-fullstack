echo "Build script started"

docker build -f api-gateway/Dockerfile -t e-commerce-backend-api-gateway-v2
docker build -f authorization-service/Dockerfile -t e-commerce-backend-authorization-service-v2
docker build -f inventory-service/Dockerfile -t e-commerce-backend-inventory-service-v2
docker build -f order-service/Dockerfile -t e-commerce-backend-order-service-v2
docker build -f product-service/Dockerfile -t e-commerce-backend-product-service-v2
docker build -f service-registry/Dockerfile -t e-commerce-backend-service-registry-v2

echo "Build completed. Please check images with cmd 'docker images'"