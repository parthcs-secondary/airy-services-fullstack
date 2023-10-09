echo "Build script started"

docker build -t e-commerce-backend-api-gateway-v2 -f api-gateway/Dockerfile
docker build -t e-commerce-backend-authorization-service-v2 -f authorization-service/Dockerfile
docker build -t e-commerce-backend-inventory-service-v2 -f inventory-service/Dockerfile
docker build -t e-commerce-backend-order-service-v2 -f order-service/Dockerfile
docker build -t e-commerce-backend-product-service-v2 -f product-service/Dockerfile
docker build -t e-commerce-backend-service-registry-v2 -f service-registry/Dockerfile

echo "Build completed. Please check images with cmd 'docker images'"