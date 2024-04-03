import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TurniComponent } from './turni.component';

describe('TurniComponent', () => {
  let component: TurniComponent;
  let fixture: ComponentFixture<TurniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TurniComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TurniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
