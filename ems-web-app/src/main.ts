import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import {AppModule} from './app/app.module';
import {environment} from './environments/environment';
import {AppInjectorService} from './app/core/app-injector.service';

if (environment.production) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
    .then((moduleRef) => {
        AppInjectorService.setInjector(moduleRef.injector);
    })
    .catch(err => console.error(err));
