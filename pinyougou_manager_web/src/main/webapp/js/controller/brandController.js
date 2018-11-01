app.controller("brandController", function ($scope, $controller, brandService) {

    $controller("baseController", {$scope: $scope})

    $scope.findAll = function () {
        brandService.findAll().success(function (date) {
            $scope.list = date
        })
    }


    $scope.findPage = function (pageNum, pageSize) {
        brandService.findPage(pageNum, pageSize).success(function (date) {
            $scope.paginationConf.totalItems = date.total
            $scope.list = date.rows;//当前页查询结果集
        })
    }

    $scope.save = function () {
        var method = null;

        if ($scope.entity.id != null) {
            method = brandService.update($scope.entity)
        } else {
            method = brandService.add($scope.entity)
        }

        method.success(function (date) {
            if (date.success) {
                $scope.reloadList()
            } else {
                alert(date.message)
            }
        })
    }

    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (date) {
            $scope.entity = date
        })
    }

    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(function () {
            $scope.reloadList()
        })
    }

})