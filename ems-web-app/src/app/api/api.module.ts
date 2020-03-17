/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { BasicErrorControllerService } from './services/basic-error-controller.service';
import { PrivilegeManagementControllerImplService } from './services/privilege-management-controller-impl.service';
import { RoleManagementControllerImplService } from './services/role-management-controller-impl.service';
import { UserManagementControllerImplService } from './services/user-management-controller-impl.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    BasicErrorControllerService,
    PrivilegeManagementControllerImplService,
    RoleManagementControllerImplService,
    UserManagementControllerImplService
  ],
})
export class ApiModule {
  static forRoot(customParams: ApiConfigurationInterface): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: {rootUrl: customParams.rootUrl}
        }
      ]
    }
  }
}
