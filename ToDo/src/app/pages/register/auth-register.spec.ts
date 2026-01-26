import { TestBed } from '@angular/core/testing';

import { AuthRegister } from './auth-register';

describe('AuthRegister', () => {
  let service: AuthRegister;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthRegister);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
